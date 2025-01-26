package com.keorber.controller;

import com.keorber.config.app_config;
import com.keorber.dto.Book;
import com.keorber.exception.DaoException;
import com.keorber.service.BookService;
import com.keorber.service.BookServiceImp;

import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(app_config.class);
        BookService bookService = context.getBean("bookService",BookService.class);
        //getBean is lookup operation

        List<Book> books = bookService.getAllBooks();
        for (Book book : books) {
            System.out.println(Objects.toString(book));
        }
    }
}
