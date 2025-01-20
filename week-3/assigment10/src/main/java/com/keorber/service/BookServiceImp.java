package com.keorber.service;

import com.keorber.Exception.DaoException;
import com.keorber.dao.BookDao;
import com.keorber.dao.BookDaoImp;
import com.keorber.dto.Book;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImp implements BookService
{
    BookDao bookDao =new BookDaoImp();
    @Override
    public List<Book> getAllBooks()
    {
        List<Book> books = null;
        try
        {
            books = bookDao.getAllBooks();
        }
        catch (DaoException | SQLException e)
        {
            e.printStackTrace();
        }
        return books;

    }

    @Override
    public Book addBook(Book book)
    {
        try
        {
            bookDao.addBook(book);
        }
        catch (DaoException | SQLException e)
        {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public void deleteBook(int id) {
        try
        {
            bookDao.deleteBook(id);
        }
        catch (DaoException | SQLException e)
        {
            e.printStackTrace();
        }


    }

    @Override
    public void updateBook(int id, Book book)
    {
        try
        {
            bookDao.updateBook(id,book);
        }
        catch (DaoException | SQLException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public Book getBookById(int id)
    {

        Book foundBook = null;
        try
        {
            foundBook = bookDao.getBookById(id);
        }
        catch (DaoException | SQLException e)
        {
            e.printStackTrace();
        }
        return foundBook;
    }
}
