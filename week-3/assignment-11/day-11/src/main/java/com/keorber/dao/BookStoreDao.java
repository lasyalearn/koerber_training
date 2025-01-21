package com.keorber.dao;

import com.keorber.dto.Book;

import java.util.List;
import com.keorber.exception.DaoException;
public interface BookStoreDao
{
    public List<Book> getAllBooks()throws DaoException;
    public Book addBook(Book book) throws DaoException;
    public void deleteBook(int id) throws DaoException;
    public void updateBook(int id, Book book) throws DaoException;
    public Book getBookById(int id) throws DaoException;

}
