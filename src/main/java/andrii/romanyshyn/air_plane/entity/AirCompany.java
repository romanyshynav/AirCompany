package andrii.romanyshyn.air_plane.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class AirCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    private LocalDate founded;

    @OneToMany(mappedBy = "airCompanyId")
    private List<AirPlane> airPlaneList = new ArrayList<>(); // todo мають бути айдішки а не обєкти
    @OneToMany(mappedBy = "airCompanyId")
    private List<Flight> flightCompanyList = new ArrayList<>(); // todo мають бути айдішки а не обєкти


}
