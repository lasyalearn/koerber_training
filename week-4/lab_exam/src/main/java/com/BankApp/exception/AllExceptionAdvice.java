package com.BankApp.exception;

import lombok.Builder;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class AllExceptionAdvice
{
    @ExceptionHandler(value = AccountNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleAccountNotFound(AccountNotFoundException exception)
    {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(exception.getMessage())
                .details(exception.getClass().getName())
                .status(404)
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .contactEmail("nZVj4@example.com")
                .build();
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(errorDetails);
    }
    
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handleMethodArgumentNotValid(MethodArgumentNotValidException exception)
    {
        String message = exception.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));

        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(message)
                .details(exception.getClass().getName())
                .status(400)
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .contactEmail("nZVj4@example.com")
                .build();
        return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(errorDetails);
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception exception)
    {

        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(exception.getMessage())
                .details(exception.getClass().getName())
                .status(500)
                .timestamp(String.valueOf(System.currentTimeMillis()))
                .contactEmail("nZVj4@example.com")
                .build();
        return ResponseEntity.status(HttpStatusCode.valueOf(500)).body(errorDetails);
    }
}
