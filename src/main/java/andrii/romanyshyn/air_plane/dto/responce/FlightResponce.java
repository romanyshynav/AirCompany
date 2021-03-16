package andrii.romanyshyn.air_plane.dto.responce;

import andrii.romanyshyn.air_plane.entity.Flight;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FlightResponce {
    private Integer id;
    private String flightStatus;
    private String departureCountry;
    private String destinationCountry;
    private Integer distance;
    private Integer estimatedFlightTime; // тип даних
    private LocalDate endedAt;
    private LocalDate delayStartedAt;
    private LocalDate createdAt;

    //    Додаткові поля з БД
    private Integer airCompanyId;
    private Integer airplaneId;


    public FlightResponce(Flight flight) {
        this.id = flight.getId();
        this.flightStatus = flight.getFlightStatus().toString();
        this.departureCountry = flight.getDepartureCountry();
        this.destinationCountry = flight.getDestinationCountry();
        this.distance = flight.getDistance();
        this.estimatedFlightTime = flight.getEstimatedFlightTime();
        this.endedAt = flight.getEndedAt();
        this.delayStartedAt = flight.getDelayStartedAt();
        this.createdAt = flight.getCreatedAt();

        //    Додаткові поля з БД
        if (flight.getAirCompanyId() != null) {
            this.airCompanyId = flight.getAirCompanyId().getId();
        }
        if (flight.getAirplaneId() != null) {
            this.airplaneId = flight.getAirplaneId().getId();
        }

    }
}
