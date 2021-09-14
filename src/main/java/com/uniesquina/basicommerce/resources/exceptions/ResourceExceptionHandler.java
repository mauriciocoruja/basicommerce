package com.uniesquina.basicommerce.resources.exceptions;

import com.uniesquina.basicommerce.service.exceptions.DatabaseException;
import com.uniesquina.basicommerce.service.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String errorMessage = "Resource not found";
        HttpStatus httpStatusCode = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(
                Instant.now(),
                httpStatusCode.value(),
                errorMessage,
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(httpStatusCode).body(standardError);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> dataBaseViolation(DatabaseException e, HttpServletRequest request) {
        String errorMessage = "Data base error. Constraint violation";
        HttpStatus httpStatusCode = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(
                Instant.now(),
                httpStatusCode.value(),
                errorMessage,
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(httpStatusCode).body(standardError);
    }


}
