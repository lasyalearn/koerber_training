//package com.koerber.dao.implementation;
//
//import com.koerber.dao.BookStoreDao;
//import com.koerber.dto.Book;
//import com.koerber.exception.BookNotFoundException;
//import org.springframework.stereotype.Repository;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//@Repository(value = "BookStoreDao")
//public class BookStoreDaoImp implements BookStoreDao
//{
//    private static Map<Integer, Book> booksMap = new HashMap<Integer, Book>();
//    private static int counter = 0;
//    static
//    {
//        booksMap.put(++counter, new Book(counter, "S001", "Harry Potter and the Chamber of Secrets" , "J k Rowling", BigDecimal.valueOf(600.00)));
//        booksMap.put(++counter,  new Book(counter, "S002", "Harry Potter and the Philosopher Stone" , "J k Rowling", BigDecimal.valueOf(700.00)));
//    }
//
//    @Override
//    public List<Book> getAllBooks()
//    {
//        return new ArrayList<Book>(booksMap.values());
//    }
//
//    @Override
//    public Book addBook(Book book)
//    {
//        book.setId(++counter);
//        booksMap.put(counter, book);
//        return booksMap.get(counter);
//    }
//
//    @Override
//    public void deleteBook(int id)
//    {
//        booksMap.remove(id);
//    }
//
//    @Override
//    public void updateBook(int id, Book book)
//    {
//        booksMap.put(id, book);
//    }
//
//    @Override
//    public Book getBookById(int id)
//    {
//        if (booksMap.containsKey(id))
//        {
//            return booksMap.get(id);
//        }
//        else {
//            throw new BookNotFoundException("Book with id " + id + " not found");
//        }
//    }
//
//}
