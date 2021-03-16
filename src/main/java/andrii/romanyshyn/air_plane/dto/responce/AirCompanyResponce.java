package andrii.romanyshyn.air_plane.dto.responce;

import andrii.romanyshyn.air_plane.entity.AirCompany;
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

    //    Додаткові поля для читання не з БД
//    private List<Integer> airPlaneIdList; // не ліст обєктів, а ліст айдішок для обєкта (OneToMany)
//    private List<Integer> flightIdCompanyList; // не ліст обєктів, а ліст айдішок для обєкта (OneToMany)

    public AirCompanyResponce(AirCompany airCompany) {
        this.id = airCompany.getId();
        this.name = airCompany.getName();
        this.type = airCompany.getType();
        this.founded = airCompany.getFounded();

        //    Додаткові поля для читання не з БД
//        if (airCompany.getAirPlaneList() != null && !airCompany.getAirPlaneList().isEmpty()) {
//            this.airPlaneIdList = airCompany.getAirPlaneList().stream()
//                    .map(plane -> plane.getId()) // приводимо до ліста айдішок обєкта
//                    .collect(Collectors.toList());
//        }
//        if (airCompany.getFlightCompanyList() != null && !airCompany.getFlightCompanyList().isEmpty()) {
//            this.flightIdCompanyList = airCompany.getFlightCompanyList().stream()
//                    .map(flight -> flight.getId()) // приводимо до ліста айдішок обєкта
//                    .collect(Collectors.toList());
//        }
    }
}
