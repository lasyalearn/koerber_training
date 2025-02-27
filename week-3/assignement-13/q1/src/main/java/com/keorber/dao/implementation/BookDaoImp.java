package com.keorber.dao.implementation;

import com.keorber.dao.BookDao;
import com.keorber.dto.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(value = "lasyaDao")

public class BookDaoImp implements BookDao {
    private static final Logger logger = LoggerFactory.getLogger(BookDaoImp.class);
    private static Map<Integer, Book> booksMap = new HashMap<Integer, Book>();
    private static int counter = 0;
    static {
        booksMap.put(++counter, new Book(counter, "ABC123", "Head first Java" , "Katthy", 600));
        booksMap.put(++counter,  new Book(counter, "ABC723", "Servlet jsp Java" , "Katthy", 700));
        booksMap.put(++counter,  new Book(counter, "ABC567", "python" , "Katthy", 740));
        booksMap.put(++counter,  new Book(counter, "ABC678", "java" , "Katthy", 730));
        booksMap.put(++counter,  new Book(counter, "ABC789", "cpp" , "Katthy", 710));
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<Book>(booksMap.values());
    }

    @Override
    public Book addBook(Book book) {
        book.setId(++counter);
        booksMap.put(counter, book);
        return booksMap.get(counter);
    }

    @Override
    public void deleteBook(int id)
    {
        logger.info("Deleting book with id {}", id);
        Book b=booksMap.get(id);
        logger.info("Deleting book {}", b);
        booksMap.remove(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        booksMap.put(id, book);
    }

    @Override
    public Book getBookById(int id) {
        return booksMap.get(id);
    }

}
