package com.keorber.service;

import com.keorber.dao.BookStoreDao;
import com.keorber.dao.implementation.BookStoreDaoJDBCImpl;
import com.keorber.dto.Book;

import java.util.List;
import java.util.Objects;

import com.keorber.exception.BookNotFoundError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class BookServiceImpl implements BookService
{
    Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    private BookStoreDao bookStoreDao = new BookStoreDaoJDBCImpl();
    @Override
    public List<Book> getAllBooks()
    {

        return bookStoreDao.getAllBooks();
    }

    @Override
    public Book addBook(Book book)
    {

        return bookStoreDao.addBook(book);
    }

    @Override
    public void deleteBook(int id)
    {
        bookStoreDao.deleteBook(id);
    }

    @Override
    public void updateBook(int id, Book book)
    {
        bookStoreDao.updateBook(id, book);
    }

    @Override
    public Book getBookById(int id)
    {
        Book book = bookStoreDao.getBookById(id);
        if(Objects.nonNull(book))
        {
            return book;
        }
        else
        {
            throw new BookNotFoundError("Book not found");
        }
    }
}
