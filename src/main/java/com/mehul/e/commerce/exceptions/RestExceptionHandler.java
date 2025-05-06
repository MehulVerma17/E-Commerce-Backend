package com.mehul.e.commerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {CategoryNotFoundException.class})
    public ResponseEntity<Object> handleEmployeeNotFoundException(CategoryNotFoundException ex) {
        return buildResponseEntityForEmployeeExceptions(ex, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<Object> buildResponseEntityForEmployeeExceptions(RuntimeException ex, HttpStatus status) {
        RestException restException = new RestException(
                ex.getMessage(),
                ex.getCause(),
                status
        );
        return new ResponseEntity<>(restException, status);
    }

}