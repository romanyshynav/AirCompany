package andrii.romanyshyn.air_plane.service;

import andrii.romanyshyn.air_plane.dto.request.AirPlaneRequest;
import andrii.romanyshyn.air_plane.dto.responce.AirPlaneResponce;
import andrii.romanyshyn.air_plane.entity.AirCompany;
import andrii.romanyshyn.air_plane.entity.AirPlane;
import andrii.romanyshyn.air_plane.repository.AirPlaneRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static andrii.romanyshyn.air_plane.exception.ExceptionHandling.ENTITY_ID_NOT_EXIST;

@Service
public class AirPlaneService {
    private final AirPlaneRepository airPlaneRepository;
    private final AirCompanyService airCompanyService;

    public AirPlaneService(AirPlaneRepository airPlaneRepository, AirCompanyService airCompanyService) {
        this.airPlaneRepository = airPlaneRepository;
        this.airCompanyService = airCompanyService;
    }

    public AirPlaneResponce changeAirCompany(Integer id, Integer companyId) {
        AirPlane airPlane = findAirPlaneById(id);
//        airPlane.setAirCompanyId(request.getAirCompanyId());
        airPlane.setAirCompanyId(airCompanyService.findAirCompanyById(companyId));

        airPlaneRepository.save(airPlane);
        return new AirPlaneResponce(airPlane);
    }


    // CRUD-Operations
    public AirPlaneResponce create(AirPlaneRequest request) {
        AirPlane airPlane = new AirPlane();
        airPlane.setName(request.getName());
        airPlane.setFactorySerialNumber(request.getFactorySerialNumber());
//        airPlane.setAirCompanyId(request.getAirCompanyId());
        airPlane.setAirCompanyId(airCompanyService.findAirCompanyById(request.getAirCompanyId()));
        airPlane.setNumberOfFlights(request.getNumberOfFlights());
        airPlane.setFlightDistance(request.getFlightDistance());
        airPlane.setFuelCapacity(request.getFuelCapacity());
        airPlane.setType(request.getType());
        airPlane.setCreatedAt(request.getCreatedAt());

        airPlaneRepository.save(airPlane);

        return new AirPlaneResponce(airPlane);
    }

    public List<AirPlaneResponce> findAll() {
        return airPlaneRepository.findAll().stream()
                .map(plane -> new AirPlaneResponce(plane))
                .collect(Collectors.toList());
    }

    public AirPlane findAirPlaneById(Integer id) {
        return airPlaneRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                String.format(ENTITY_ID_NOT_EXIST, AirCompany.class.getSimpleName(), id)));
    }
}
