package andrii.romanyshyn.air_plane.dto.responce;

import andrii.romanyshyn.air_plane.entity.AirCompany;
import andrii.romanyshyn.air_plane.entity.AirPlane;
import andrii.romanyshyn.air_plane.entity.Flight;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class AirCompanyResponce {
    private Integer id;
    private String name;
    private String type;
    private LocalDate founded;

    private List<Integer> airPlaneIdList;
    private List<Integer> flightIdCompanyList;

    public AirCompanyResponce(AirCompany airCompany) {
        this.id = airCompany.getId();
        this.name = airCompany.getName();
        this.type = airCompany.getType();
        this.founded = airCompany.getFounded();

        if (airCompany.getAirPlaneList() != null && !airCompany.getAirPlaneList().isEmpty()) {
            this.airPlaneIdList = airCompany.getAirPlaneList().stream()
                    .map(AirPlane::getId)
                    .collect(Collectors.toList());
        }
        if (airCompany.getFlightCompanyList() != null && !airCompany.getFlightCompanyList().isEmpty()) {
            this.flightIdCompanyList = airCompany.getFlightCompanyList().stream()
                    .map(Flight::getId)
                    .collect(Collectors.toList());
        }
    }
}
