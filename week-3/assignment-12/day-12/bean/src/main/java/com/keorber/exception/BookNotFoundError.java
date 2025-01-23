package com.keorber.exception;

public class BookNotFoundError extends RuntimeException
{
    public BookNotFoundError(String message)
    {
        super(message);
    }
}
