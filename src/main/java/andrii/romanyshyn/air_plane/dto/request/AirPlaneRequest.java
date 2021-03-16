package andrii.romanyshyn.air_plane.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AirPlaneRequest {
    private String name;
    private String factorySerialNumber;
    private Integer airCompanyId;
    private Integer numberOfFlights;
    private Integer flightDistance;
    private Integer fuelCapacity;
    private String type;
    private LocalDate createdAt;
}
