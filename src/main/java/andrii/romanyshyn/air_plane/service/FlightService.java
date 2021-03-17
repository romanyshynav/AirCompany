package andrii.romanyshyn.air_plane.service;

import andrii.romanyshyn.air_plane.dto.request.FlightRequest;
import andrii.romanyshyn.air_plane.dto.responce.FlightResponce;
import andrii.romanyshyn.air_plane.entity.Flight;
import andrii.romanyshyn.air_plane.entity.FlightStatus;
import andrii.romanyshyn.air_plane.repository.FlightRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static andrii.romanyshyn.air_plane.exception.ExceptionHandling.ENTITY_ID_NOT_EXIST;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    private final AirCompanyService airCompanyService;
    private final AirPlaneService airPlaneService;

    public FlightService(FlightRepository flightRepository, AirCompanyService airCompanyService, AirPlaneService airPlaneService) {
        this.flightRepository = flightRepository;
        this.airCompanyService = airCompanyService;
        this.airPlaneService = airPlaneService;
    }

    //    =========МЕТОДИ===============================================================================================

    public List<FlightResponce> findAirCompanyFlightsByCompanyNameAndStatus(FlightStatus flightStatus, String companyName) {
        return flightRepository.findAirCompanyFlightsByCompanyNameAndStatus(flightStatus.name(), companyName).stream()
                .map(FlightResponce::new)
                .collect(Collectors.toList());
    }

    public List<FlightResponce> findFlightByActiveStatusMoreThan24Hours() {
        FlightStatus flightStatus = FlightStatus.ACTIVE;
        return flightRepository.findFlightByActiveStatusMoreThan24Hours(flightStatus).stream()
                .filter(flight -> flight.getCreatedAt().compareTo(LocalDate.now()) < -1)
                .map(FlightResponce::new)
                .collect(Collectors.toList());
    }

    public FlightResponce changeFlightStatus(Integer id, FlightStatus flightStatus) {
        Flight flight = findFlightById(id);
        if (flightStatus.equals(FlightStatus.DELAYED)) {
            flight.setFlightStatus(flightStatus);
            flight.setDelayStartedAt(LocalDate.now());
        } else if (flightStatus.equals(FlightStatus.COMPLETED)) {
            flight.setFlightStatus(flightStatus);
            flight.setEndedAt(LocalDate.now());
        }

        flightRepository.save(flight);
        return new FlightResponce(flight);
    }

    // CRUD-Operations
    public FlightResponce create(FlightRequest request) {
        Flight flight = new Flight();
        flight.setFlightStatus(FlightStatus.PENDING);
        flight.setAirCompanyId(airCompanyService.findAirCompanyById(request.getAirCompanyId()));
        flight.setAirplaneId(airPlaneService.findAirPlaneById(request.getAirplaneId()));
        flight.setDepartureCountry(request.getDepartureCountry());
        flight.setDestinationCountry(request.getDepartureCountry());
        flight.setDistance(request.getDistance());
        flight.setEstimatedFlightTime(request.getEstimatedFlightTime());
        flight.setCreatedAt(LocalDate.now());

        flightRepository.save(flight);

        return new FlightResponce(flight);
    }

    public List<FlightResponce> findAll() {
        return flightRepository.findAll().stream()
                .map(FlightResponce::new)
                .collect(Collectors.toList());
    }

    public Flight findFlightById(Integer id) {
        return flightRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                String.format(ENTITY_ID_NOT_EXIST, Flight.class.getSimpleName(), id)));
    }
}
