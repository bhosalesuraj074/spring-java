// Renamed file: GlobalExceptionHandler.java
package com.bigbasket.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public String handleProductNotFoundException(ResourceNotFoundException ex) {
        return "Error: " + ex.getMessage();
    }

    @ExceptionHandler(value = Exception.class)
    public String handleGeneralException(Exception ex) {
        return "An unexpected error occurred: " + ex.getMessage();
    }
}