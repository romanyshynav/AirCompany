package andrii.romanyshyn.air_plane.service;

import andrii.romanyshyn.air_plane.dto.request.AirCompanyRequest;
import andrii.romanyshyn.air_plane.dto.responce.AirCompanyResponce;
import andrii.romanyshyn.air_plane.entity.AirCompany;
import andrii.romanyshyn.air_plane.repository.AirCompanyRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static andrii.romanyshyn.air_plane.exception.ExceptionHandling.ENTITY_ID_NOT_EXIST;

@Service
public class AirCompanyService {
    private final AirCompanyRepository airCompanyRepository;

    public AirCompanyService(AirCompanyRepository airCompanyRepository) {
        this.airCompanyRepository = airCompanyRepository;
    }

    // CRUD-Operations
    public AirCompany create(AirCompanyRequest request) {
        AirCompany airCompany = new AirCompany();
        airCompany.setName(request.getName());
        airCompany.setType(request.getType());
        airCompany.setFounded(LocalDate.now());

        return airCompanyRepository.save(airCompany);
    }

    public AirCompany update(Integer id, AirCompanyRequest request) {
        AirCompany airCompany = findAirCompanyById(id);
        airCompany.setName(request.getName());
        airCompany.setType(request.getType());
        airCompany.setFounded(request.getFounded());

        return airCompanyRepository.save(airCompany);
    }

    public void delete(Integer id) {
        AirCompany airCompany = findAirCompanyById(id);
        airCompanyRepository.delete(airCompany);
    }

    public List<AirCompanyResponce> findAll() {
        return airCompanyRepository.findAll().stream()
                .map(AirCompanyResponce::new)
                .collect(Collectors.toList());
    }

    public AirCompany findAirCompanyById(Integer id) {
        return airCompanyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                String.format(ENTITY_ID_NOT_EXIST, AirCompany.class.getSimpleName(), id)));
    }

}
