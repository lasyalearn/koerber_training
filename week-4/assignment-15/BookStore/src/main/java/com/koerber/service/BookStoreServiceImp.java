package com.koerber.service;

import com.koerber.dao.BookStoreDao;
import com.koerber.dto.Book;
import com.koerber.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "bookStoreService")
public class BookStoreServiceImp implements BookStoreService {

    private final BookStoreDao bookStoreDao;

    @Autowired
    public BookStoreServiceImp(BookStoreDao bookStoreDao) {
        this.bookStoreDao = bookStoreDao;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookStoreDao.findAll();
    }

    @Override
    public Book addBook(Book book) {
        return bookStoreDao.save(book);
    }

    @Override
    public void deleteBook(int id) {
        // Use deleteById directly, no need to fetch the book first
        bookStoreDao.deleteById(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        // Use Optional to check if the book exists
        Optional<Book> optionalBook = bookStoreDao.findById(id);

        if (optionalBook.isPresent()) {
            Book bookToUpdate = optionalBook.get();
            bookToUpdate.setTitle(book.getTitle());
            bookToUpdate.setAuthor(book.getAuthor());
            bookToUpdate.setIsbn(book.getIsbn());
            bookToUpdate.setPrice(book.getPrice());
            bookStoreDao.save(bookToUpdate);
        } else {
            throw new BookNotFoundException("Book with id " + id + " not found");
        }
    }

    @Override
    public Book getBookById(int id) {
        Optional<Book> optionalBook = bookStoreDao.findById(id);
        if (optionalBook.isEmpty()) {
            throw new BookNotFoundException("Book with id " + id + " not found");
        }
        return optionalBook.get();
    }
}
