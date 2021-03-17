package andrii.romanyshyn.air_plane.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class AirPlane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String factorySerialNumber;
    @ManyToOne
    private AirCompany airCompanyId;
    private Integer numberOfFlights;
    private Integer flightDistance;
    private Integer fuelCapacity;
    private String type;
    private LocalDate createdAt;

    @OneToMany(mappedBy = "airplaneId")
    private List<Flight> flightPlaneList = new ArrayList<>();

}
