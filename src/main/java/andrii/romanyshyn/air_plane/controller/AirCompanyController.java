package andrii.romanyshyn.air_plane.controller;

import andrii.romanyshyn.air_plane.dto.request.AirCompanyRequest;
import andrii.romanyshyn.air_plane.dto.responce.AirCompanyResponce;
import andrii.romanyshyn.air_plane.entity.AirCompany;
import andrii.romanyshyn.air_plane.service.AirCompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airCompanies")
public class AirCompanyController {
    private final AirCompanyService airCompanyService;

    public AirCompanyController(AirCompanyService airCompanyService) {
        this.airCompanyService = airCompanyService;
    }

    // CRUD-Operations

    @PostMapping
    public AirCompany create(@RequestBody AirCompanyRequest request) {
        return airCompanyService.create(request);
    }

    @PutMapping("/{id}")
    public AirCompany update(@PathVariable Integer id, @RequestBody AirCompanyRequest request) {
        return airCompanyService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        airCompanyService.delete(id);
    }

    @GetMapping
    public List<AirCompanyResponce> findAll() {
        return airCompanyService.findAll();
    }
}
