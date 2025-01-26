package com.keorber.service;

import com.keorber.dto.Book;

import java.util.List;

public interface BookService
{
    public Book addBook(Book book);
    public void updateBook(Book book);
    public List<Book> getAllBooks();
    public Book getBook(int id);
    public void deleteBook(int id);

}
