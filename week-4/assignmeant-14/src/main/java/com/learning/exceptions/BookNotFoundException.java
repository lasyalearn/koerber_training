package com.learning.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message)
    {
        super(message);
    }
}
