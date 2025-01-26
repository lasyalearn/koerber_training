package com.keorber.controller;

import com.keorber.dao.implementation.BookDaoHibernetImpl;
import com.keorber.dto.Book;
import com.keorber.service.BookService;
import com.keorber.service.BookServiceImpl;
import config.app_config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
    public static void main( String[] args )
    {
        //USe of bean instead of @Component

        ApplicationContext context = new AnnotationConfigApplicationContext(app_config.class);
        BookService bookService = context.getBean("bookService", BookService.class);
        //it is the automatically dependency
        System.out.println( bookService.getAllBooks() );



//        //here total elemination of xml
//        ApplicationContext context = new AnnotationConfigApplicationContext(app_config.class);
//        BookService bookService = context.getBean("bookService", BookService.class);
//        //it is the automatically dependency
//        System.out.println( bookService.getAllBooks() );



        //xml+annotation
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.keorber");
//        //this worked but u should be using
//        // ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        BookService bookService = context.getBean("bookService", BookService.class);
//        //it is the automatically dependency
//        System.out.println( bookService.getAllBooks() );




        //xml
        // properties --> calls setters
        // the name of the property is the name of the setter(set+ Captitalize the first letter)
        // if u write autowire="byName" then u have to write the name of the setter
        //if u write autowire="byType" then u dont have to write the name of the setter
        // u don't have write property
        //here setter injection
        //Setter is used for optional injection
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        BookService bookService = context.getBean("bookService", BookService.class);
////        BookServiceImpl bookService = new BookServiceImpl();
////        //bookService.setBookDao(new BookDaoHibernetImpl());
//        // it is the manually dependency
//        System.out.println( bookService.getAllBooks() );

//        System.out.println( bookService.getBook(2) );
//
//        bookService.deleteBook(2);
//
//        System.out.println( bookService.getAllBooks() );

//        Book book = bookService.addBook( new Book(1, "S001", "Game of Thrones", "George Martin", 24.95) );
//
//        System.out.println( bookService.getAllBooks() );
//
//        bookService.updateBook( new Book(1, "S001", "Game of Thrones 2", "George Martin", 24.95) );
//
//        System.out.println( bookService.getAllBooks() );



    }
}
