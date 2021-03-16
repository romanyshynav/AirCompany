package andrii.romanyshyn.air_plane.service;

import andrii.romanyshyn.air_plane.dto.request.FlightRequest;
import andrii.romanyshyn.air_plane.dto.responce.FlightResponce;
import andrii.romanyshyn.air_plane.entity.Flight;
import andrii.romanyshyn.air_plane.entity.FlightStatus;
import andrii.romanyshyn.air_plane.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
                .map(flight -> new FlightResponce(flight))
                .collect(Collectors.toList());
    }

    public List<FlightResponce> findFlightByActiveStatusMoreThan24Hours(FlightStatus flightStatus) {
        return flightRepository.findFlightByActiveStatusMoreThan24Hours(flightStatus).stream()
                .map(flight -> new FlightResponce(flight))
                .collect(Collectors.toList());
    }

    // CRUD-Operations
    public FlightResponce create(FlightRequest request) {
        Flight flight = new Flight();
        flight.setFlightStatus(FlightStatus.valueOf(request.getFlightStatus()));
//        flight.setAirCompanyId(request.getAirCompanyId());
        flight.setAirCompanyId(airCompanyService.findAirCompanyById(request.getAirCompanyId()));
//        flight.setAirplaneId(request.getAirplaneId());
        flight.setAirplaneId(airPlaneService.findAirPlaneById(request.getAirplaneId()));
        flight.setDepartureCountry(request.getDepartureCountry());
        flight.setDestinationCountry(request.getDepartureCountry());
        flight.setDistance(request.getDistance());
        flight.setEstimatedFlightTime(request.getEstimatedFlightTime());
        flight.setEndedAt(request.getEndedAt());
        flight.setDelayStartedAt(request.getDelayStartedAt());
        flight.setCreatedAt(request.getCreatedAt());

        flightRepository.save(flight);

        return new FlightResponce(flight);
    }

    public List<FlightResponce> findAll() {
        return flightRepository.findAll().stream()
                .map(flight -> new FlightResponce(flight))
                .collect(Collectors.toList());
    }

}
