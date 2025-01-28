package com.koerber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// whenever u get an exception we want to transfer the control from controller to exception handler
@RestControllerAdvice
// it helps in centralized exception handling
// it throws advices
// can added more exception to handle null pointer exception and etc

public class AllExceptionHandler
{
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ExceptionErrorDetails> handleBookNotFoundException(BookNotFoundException ex)
    {
        ExceptionErrorDetails details = new ExceptionErrorDetails();
        details.setTimeStamp(System.currentTimeMillis());
        details.setMessage(ex.getMessage());
        details.setDetails(ex.getClass().getName());
        details.setSupportEmail("koerberdevelopmentsupport@koerber.com");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionErrorDetails> handleException(Exception ex)
    {
        ExceptionErrorDetails details = new ExceptionErrorDetails();
        details.setTimeStamp(System.currentTimeMillis());
        details.setMessage(ex.getMessage());
        details.setDetails(ex.getClass().getName());
        details.setSupportEmail("koerberdevelopmentsupport@koerber.com");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(details);
    }


}
