package com.keorber.web;

import com.keorber.Exception.DaoException;
import com.keorber.dto.Book;
import com.keorber.service.BookService;
import com.keorber.service.BookServiceImp;

import java.sql.SQLException;
import java.util.List;

public class Main
{
    public static void main( String[] args )
    {
        BookService bookService = new BookServiceImp();
        //to get all books
        try
        {
            List<Book> books = bookService.getAllBooks();
            books.forEach(System.out::println);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        // to add a book
        System.out.println("===============================================================");
//        Book book = new Book(5,"1234","book1","author1",100.0);
//        try
//        {
//            bookService.addBook(book);
//        }
//        catch (SQLException | DaoException e)
//        {
//            throw new RuntimeException(e);
//        }
//        try
//        {
//            List<Book> books = bookService.getAllBooks();
//            books.forEach(System.out::println);
//        }
//        catch (SQLException e)
//        {
//            throw new RuntimeException(e);
//        }
        System.out.println("===============================================================");
        // to delete a book
        try
        {
            bookService.deleteBook(5);
        }
        catch (SQLException | DaoException e)
        {
            throw new RuntimeException(e);
        }
        try
        {
            List<Book> books = bookService.getAllBooks();
            books.forEach(System.out::println);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        System.out.println("===============================================================");
        // to update a book
        Book book = new Book(4,"1234","book1","author1",100.0);
        try
        {
            bookService.updateBook(4,book);
        }
        catch (SQLException | DaoException e)
        {
            throw new RuntimeException(e);
        }
        try
        {
            List<Book> books = bookService.getAllBooks();
            books.forEach(System.out::println);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        System.out.println("===============================================================");
        // to get a book by id
        try
        {
            Book book1 = bookService.getBookById(4);
            System.out.println(book1);
        }
        catch (SQLException | DaoException e)
        {
            throw new RuntimeException(e);
        }
        System.out.println("===============================================================");



    }
}
