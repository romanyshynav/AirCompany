package andrii.romanyshyn.air_plane.dto.responce;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class HttpResponseDelete {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss", timezone = "Europe/Kiev")
    private Date timeStamp;
    private HttpStatus httpStatus;
    private String message;

    public HttpResponseDelete(HttpStatus httpStatus, String message) {
        this.timeStamp = new Date();
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
