package com.koerber.service;

import com.koerber.dto.Book;

import java.util.List;
import java.util.Optional;

public interface BookStoreService
{
    public List<Book> getAllBooks();
    public Book addBook(Book book);
    public void deleteBook(int id);
    public void updateBook(int id, Book book);
    public Book getBookById(int id);

}
