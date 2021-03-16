package andrii.romanyshyn.air_plane.exception;

import andrii.romanyshyn.air_plane.dto.responce.HttpResponseDelete;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ExceptionHandling {

    public static final String ENTITY_ID_NOT_EXIST = "%s with ID - %d - does not exist.";

    @ExceptionHandler(EntityNotFoundException.class)
    public HttpResponseDelete entityNotFoundException(EntityNotFoundException exception) {
        return new HttpResponseDelete(BAD_REQUEST, exception.getMessage());
    }

}
