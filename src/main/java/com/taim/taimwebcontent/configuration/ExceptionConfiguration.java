package com.taim.taimwebcontent.configuration;

import com.taim.taimbackendservice.exception.InternalServerErrorException;
import com.taim.taimbackendservice.exception.ResourceNotFoundException;
import com.taim.taimwebcontent.model.ExceptionEntity;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class ExceptionConfiguration extends ResponseEntityExceptionHandler {

    @ControllerAdvice
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public static class DetailedExceptionHandler{
        @ExceptionHandler({ResourceNotFoundException.class})
        public ResponseEntity notFoundExceptionHandler(Exception ex) {
            return error(ex, HttpStatus.NOT_FOUND);
        }
    }

    @ControllerAdvice
    @Order(Ordered.LOWEST_PRECEDENCE)
    public static class DefaultExceptionHandler{
        @ExceptionHandler({InternalServerErrorException.class, Exception.class})
        public ResponseEntity generalExceptionHandler(Exception ex) {

            return error(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static ResponseEntity<ExceptionEntity> error(Exception ex, HttpStatus httpStatus) {

        ExceptionEntity errorEntity = ExceptionEntity.builder()
                .error(ExceptionUtils.getRootCauseMessage(ex))
                .description(httpStatus.getReasonPhrase())
                .httpCode(httpStatus.value())
                .timeStamp(new Date())
                .build();

        return new ResponseEntity<>(errorEntity, httpStatus);
    }
}
