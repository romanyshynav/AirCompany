package andrii.romanyshyn.air_plane.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AirCompanyRequest {
    private String name;
    private String type;
    private LocalDate founded;
}
