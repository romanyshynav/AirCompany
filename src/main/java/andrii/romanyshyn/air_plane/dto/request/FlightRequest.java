package andrii.romanyshyn.air_plane.dto.request;

import lombok.Data;

import java.time.LocalDate;
@Data
public class FlightRequest {
    private String flightStatus;
    private Integer airCompanyId;
    private Integer airplaneId;
    private String departureCountry;
    private String destinationCountry;
    private Integer distance;
    private Integer estimatedFlightTime; // тип даних
    private LocalDate endedAt;
    private LocalDate delayStartedAt;
    private LocalDate createdAt;
}
