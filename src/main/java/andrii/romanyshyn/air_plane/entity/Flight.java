package andrii.romanyshyn.air_plane.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private FlightStatus flightStatus;
    @ManyToOne
    private AirCompany airCompanyId;
    @ManyToOne
    private AirPlane airplaneId;
    private String departureCountry;
    private String destinationCountry;
    private Integer distance;
    private Integer estimatedFlightTime;
    private LocalDate endedAt;
    private LocalDate delayStartedAt;
    private LocalDate createdAt;

}
