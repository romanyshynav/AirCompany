package andrii.romanyshyn.air_plane.dto.responce;

import andrii.romanyshyn.air_plane.entity.AirPlane;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class AirPlaneResponce {
    private Integer id;
    private String name;
    private String factorySerialNumber;
    private Integer numberOfFlights;
    private Integer flightDistance;
    private Integer fuelCapacity;
    private String type;
    private LocalDate createdAt;

    //    Додаткові поля з БД
    private Integer airCompanyId; // передається не обєкт, а айдішка для обєкта (ManyToOne)
    private List<Integer> flightIdPlaneList; // не ліст обєктів, а ліст айдішок для обєкта (OneToMany)

    public AirPlaneResponce(AirPlane airPlane) {
        this.id = airPlane.getId();
        this.name = airPlane.getName();
        this.factorySerialNumber = airPlane.getFactorySerialNumber();
        this.numberOfFlights = airPlane.getNumberOfFlights();
        this.flightDistance = airPlane.getFlightDistance();
        this.fuelCapacity = airPlane.getFuelCapacity();
        this.type = airPlane.getType();
        this.createdAt = airPlane.getCreatedAt();

        //    Додаткові поля з БД
        if (airPlane.getAirCompanyId() != null) {
            this.airCompanyId = airPlane.getAirCompanyId().getId();
        }
        if (airPlane.getFlightPlaneList() != null && !airPlane.getFlightPlaneList().isEmpty()) {
            this.flightIdPlaneList = airPlane.getFlightPlaneList().stream()
                    .map(flight -> flight.getId()) // приводимо до ліста айдішок обєкта
                    .collect(Collectors.toList());
        }
    }

}
