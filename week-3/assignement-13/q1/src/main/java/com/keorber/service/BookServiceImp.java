package com.keorber.service;

import com.keorber.dao.BookDao;

import com.keorber.dao.implementation.BookDaoImp;

import com.keorber.dto.Book;

import java.util.List;
import java.util.Objects;

import com.keorber.exception.BookNotFoundError;
import com.keorber.service.Aspects.Loggable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component(value = "bookService")
public  class BookServiceImp implements BookService {

    //BAD CODE HARD CODING....
    /*
    * <bean id="bookService" class="com.keorber.service.BookServiceImp" autowire="byType">

    </bean>
    * */
    @Autowired
    private BookDao dao;
    // weshould define dao
    public void setDao(BookDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Book> getAllBooks() {
        return dao.getAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        return dao.addBook(book);
    }

    @Loggable
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

