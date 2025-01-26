package com.keorber.service;

import com.keorber.dao.BookDao;

import com.keorber.dao.implementation.BookStoreDaoJDBCImpl;

import com.keorber.dto.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import com.keorber.exception.BookNotFoundError;
import com.keorber.exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("bookService")
public  class BookServiceImp implements BookService {

    //BAD CODE HARD CODING....
    /*
    * <bean id="bookService" class="com.keorber.service.BookServiceImp" autowire="byType">

    </bean>
    * */
    private BookDao dao;
    @Autowired
    public BookServiceImp(BookDao dao)
    {
        this.dao = dao;
    }

//    public BookServiceImp(BookDao dao) {
//        this.dao = dao;
//    }

    // weshould define dao
    public void setDao(BookDao dao)
    {
        this.dao = dao;
    }

    @Override
    public List<Book> getAllBooks() {
        try
        {
            return dao.getAllBooks();
        } catch (SQLException e) {
            throw new DaoException("Couldn't get all the books",e);
        }
    }

    @Override
    public Book addBook(Book book) {
        return dao.addBook(book);
    }

    @Override
    public void deleteBook(int id) {
        dao.deleteBook(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        dao.updateBook(id, book);
    }

    @Override
    public Book getBookById(int id) {
        return dao.getBookById(id);
    }

}

