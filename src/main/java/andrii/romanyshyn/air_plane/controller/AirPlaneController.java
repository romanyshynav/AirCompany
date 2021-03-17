package andrii.romanyshyn.air_plane.controller;

import andrii.romanyshyn.air_plane.dto.request.AirPlaneRequest;
import andrii.romanyshyn.air_plane.dto.responce.AirPlaneResponce;
import andrii.romanyshyn.air_plane.service.AirPlaneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airPlanes")
public class AirPlaneController {
    private final AirPlaneService airPlaneService;

    public AirPlaneController(AirPlaneService airPlaneService) {
        this.airPlaneService = airPlaneService;
    }

    @PutMapping("/{id}/{companyId}")
    public AirPlaneResponce changeAirCompany(@PathVariable Integer id, @PathVariable Integer companyId) {
        return airPlaneService.changeAirCompany(id, companyId);
    }

    // CRUD-Operations
    @PostMapping
    public AirPlaneResponce create(@RequestBody AirPlaneRequest request) {
        return airPlaneService.create(request);
    }

    @GetMapping
    public List<AirPlaneResponce> findAll() {
        return airPlaneService.findAll();
    }

}
