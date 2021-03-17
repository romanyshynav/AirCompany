package andrii.romanyshyn.air_plane.dto.request;

import lombok.Data;

@Data
public class FlightRequest {
    private Integer airCompanyId;
    private Integer airplaneId;
    private String departureCountry;
    private String destinationCountry;
    private Integer distance;
    private Integer estimatedFlightTime;
}
