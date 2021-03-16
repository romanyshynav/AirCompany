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
//    @ManyToOne
    private Integer airCompanyId;
//    @ManyToOne
    private Integer airplaneId;
    private String departureCountry;
    private String destinationCountry;
    private Integer distance;
    private Integer estimatedFlightTime; // тип даних
    private LocalDate endedAt;
    private LocalDate delayStartedAt;
    private LocalDate createdAt;

}
