package com.learning.service;

import com.learning.dao.BookDao;
import com.learning.dto.Book;
import com.learning.exceptions.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("bookService")
public class BookServiceImp implements BookService
{
    BookDao bookDao;

    @Autowired
    public BookServiceImp(BookDao bookDao)
    {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public Book addBook(Book book)
    {
        return bookDao.save(book);
    }

    @Override
    public void deleteBook(int id)
    {
        bookDao.deleteById(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        // Use Optional to check if the book exists
        Optional<Book> optionalBook = bookDao.findById(id);

        if (optionalBook.isPresent()) {
            Book bookToUpdate = optionalBook.get();
            bookToUpdate.setTitle(book.getTitle());
            bookToUpdate.setAuthor(book.getAuthor());
            bookToUpdate.setIsbn(book.getIsbn());
            bookToUpdate.setPrice(book.getPrice());
            bookDao.save(bookToUpdate);
        } else {
            throw new BookNotFoundException("Book with id " + id + " not found");
        }
    }

    @Override
    public Book getBookById(int id) {
        Optional<Book> optionalBook = bookDao.findById(id);
        if (optionalBook.isEmpty()) {
            throw new BookNotFoundException("Book with id " + id + " not found");
        }
        return optionalBook.get();
    }
}
