package com.learning.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class AllExceptionAdvice
{
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleBookNotFoundException(BookNotFoundException ex)
    {
        ErrorDetails errorDetails;
        errorDetails = new ErrorDetails();
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setDetails(ex.getClass().getName());
        errorDetails.setTimestamp(System.currentTimeMillis());
        errorDetails.setSupportEmail("support@learningapp");
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(errorDetails);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handle400(MethodArgumentNotValidException ex){

        String errorMessage= ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(e->e.getDefaultMessage())
                .collect(Collectors.joining(", "));


        ErrorDetails errorDetails=
                ErrorDetails.builder()
                        .message(errorMessage)
                        .details(ex.getClass().getName())
                        .timestamp(System.currentTimeMillis())
                        .supportEmail("support@learningapp").build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception ex)
    {
        ErrorDetails errorDetails;
        errorDetails = new ErrorDetails();
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setDetails(ex.getClass().getName());
        errorDetails.setTimestamp(System.currentTimeMillis());
        errorDetails.setSupportEmail("support@learningapp");
        return ResponseEntity.status(HttpStatusCode.valueOf(500)).body(errorDetails);
    }

}
