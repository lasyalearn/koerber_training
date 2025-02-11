package com.BookApplication.service;

import com.BookApplication.dto.Book;
import com.BookApplication.entites.BookEntity;

import java.util.List;

public interface BookService
{

    public BookEntity addBook(BookEntity book);
    public BookEntity getBook(int bookId);
    public List<BookEntity> getAllBooks();
    public BookEntity deleteBook(int bookId);
}
