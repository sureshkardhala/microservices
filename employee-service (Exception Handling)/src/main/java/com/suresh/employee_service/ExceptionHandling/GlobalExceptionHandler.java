package com.suresh.employee_service.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleNotFound(ResourceNotFoundException ex){
        return new ResponseEntity<>(Map.of("timestamp", LocalDateTime.now(),
                "error", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExternalServiceException.class)
    public ResponseEntity<?> handleExternalError(ExternalServiceException ex) {
        return new ResponseEntity<>(Map.of(
                "timestamp", LocalDateTime.now(),
                "error", "Failed to fetch from Address Service",
                "details", ex.getMessage()
        ), HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneric(Exception ex) {
        return new ResponseEntity<>(Map.of(
                "timestamp", LocalDateTime.now(),
                "error", "Something went wrong",
                "details", ex.getMessage()
        ), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException ex){
        return  new ResponseEntity<>(Map.of(
                "timestamp", LocalDateTime.now(),
                "error", "Something went wrong",
                "details", ex.getMessage()
        ), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
