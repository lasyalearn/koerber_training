package com.keorber.controller;

import com.keorber.dto.Book;
import com.keorber.exception.DaoException;
import com.keorber.service.BookService;
import com.keorber.service.BookServiceImpl;

import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Main
{
    public static void main( String[] args )
    {

        System.out.println("====================================================");
        System.out.println("====================================================");
        Logger logger = LoggerFactory.getLogger(Main.class);
        // getting all the books
        logger.info("Getting all books from main");
        BookService bookService=new BookServiceImpl();
        System.out.println("All books are ");
        try{
            List<Book> Books = bookService.getAllBooks();
            for(Book b: Books){
                System.out.println(b);
            }
            logger.info("Done getting all the books");
        }catch (DaoException e)
        {
            logger.error("Couldn't get all the books");
            logger.error(e.getMessage());
            logger.error(String.valueOf(e.getCause()));
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }

        //getting book by id
        System.out.println("====================================================");
        System.out.println("====================================================");
        logger.info("Getting book by id from main");
        try{
            Book book = bookService.getBookById(1);
            System.out.println(book);
            logger.info("Done getting the book by id");
        }catch (DaoException e)
        {
            logger.error("Couldn't get the book by id");
            logger.error(e.getMessage());
            logger.error(String.valueOf(e.getCause()));
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }

        System.out.println("====================================================");
        System.out.println("====================================================");
        //adding book
        logger.info("Adding book from main");
        try{
            Book book = new Book(6,"S006", "infios1", "koerber1", 11000.0);
            Book book1 = bookService.addBook(book);
            System.out.println(book1);
            logger.info("Done adding the book");
        }catch (DaoException e)
        {
            logger.error("Couldn't add the book");
            logger.error(e.getMessage());
            logger.error(String.valueOf(e.getCause()));
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
        System.out.println("====================================================");
        System.out.println("====================================================");
        logger.info("Deleting a book");
        //deleting a book
        try
        {
            bookService.deleteBook(3);
        }
        catch (DaoException e)
        {
            logger.error("Couldn't delete the book");
            logger.error(e.getMessage());
            logger.error(String.valueOf(e.getCause()));
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
        System.out.println("====================================================");
        System.out.println("====================================================");

        //update a book
        logger.info("Updating a book");
        try
        {
            Book book = new Book(1,"S001", "infios_new", "koerber_new", 50000.0);
            bookService.updateBook(1, book);
        }
        catch (DaoException e)
        {
            logger.error("Couldn't update the book");
            logger.error(e.getMessage());
            logger.error(String.valueOf(e.getCause()));
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
        System.out.println("====================================================");
        System.out.println("====================================================");

    }
}
