package com.keorber.dao;

import com.keorber.dto.Book;

import java.util.List;
import com.keorber.exception.DaoException;
public interface BookDao {
    public List<Book> getAllBooks();
    public Book addBook(Book book);
    public void deleteBook(int id);
    public void updateBook(int id, Book book);
    public Book getBookById(int id);
}
