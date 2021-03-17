package andrii.romanyshyn.air_plane.controller;

import andrii.romanyshyn.air_plane.dto.request.FlightRequest;
import andrii.romanyshyn.air_plane.dto.responce.FlightResponce;
import andrii.romanyshyn.air_plane.entity.FlightStatus;
import andrii.romanyshyn.air_plane.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/findTask3")
    public List<FlightResponce> findAirCompanyFlightsByCompanyNameAndStatus(String statusString, String companyName) {
        return flightService.findAirCompanyFlightsByCompanyNameAndStatus(FlightStatus.valueOf(statusString), companyName);
    }

    @GetMapping("/findTask4")
    public List<FlightResponce> findFlightByActiveStatusMoreThan24Hours() {
        return flightService.findFlightByActiveStatusMoreThan24Hours();
    }

    @PutMapping("/{id}/{statusString}")
    public FlightResponce changeFlightStatus(@PathVariable Integer id, @PathVariable String statusString) {
        return flightService.changeFlightStatus(id, FlightStatus.valueOf(statusString));
    }

    // CRUD-Operations
    @PostMapping
    public FlightResponce create(@RequestBody FlightRequest request) {
        return flightService.create(request);
    }

    @GetMapping
    public List<FlightResponce> findAll() {
        return flightService.findAll();
    }

}
