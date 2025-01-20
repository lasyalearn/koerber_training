package com.keorber.dao;

import com.keorber.Exception.DaoException;
import com.keorber.dto.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao
{
    public List<Book> getAllBooks() throws DaoException, SQLException;
    public Book addBook(Book book) throws DaoException, SQLException;
    public void deleteBook(int id) throws DaoException, SQLException;
    public void updateBook(int id, Book book) throws DaoException, SQLException;
    public Book getBookById(int id) throws DaoException, SQLException;


}
