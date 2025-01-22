package com.keorber.service;

import com.keorber.dao.BookDao;

import com.keorber.dao.implementation.BookDaoImp;

import com.keorber.dto.Book;

import java.util.List;
import java.util.Objects;

import com.keorber.exception.BookNotFoundError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public  class BookServiceImp implements BookService {

    //BAD CODE HARD CODING....

    private BookDao dao=null;

    public BookServiceImp() {
        dao=new BookDaoImp();
    }


    @Override
    public List<Book> getAllBooks() {
        return dao.getAllBooks();
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

