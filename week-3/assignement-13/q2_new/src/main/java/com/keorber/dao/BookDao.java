package com.keorber.dao;

import com.keorber.dto.Book;

import java.util.List;

public interface BookDao
{
    public Book addBook(Book book);
    public void updateBook(Book book);
    public List<Book> getAllBooks();
    public Book getBook(int id);
    public void deleteBook(int id);

}
