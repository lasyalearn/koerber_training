package com.BookApplication.service;

import com.BookApplication.dao.BookRepo;
import com.BookApplication.dto.Book;
import com.BookApplication.entites.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.BookApplication.config.ConversionClass.toBook;
import static com.BookApplication.config.ConversionClass.toBookEntity;

@Service
public class BookServiceImpl implements BookService
{

    private BookRepo bookRepo;

    @Autowired
    public BookServiceImpl(BookRepo bookRepo)
    {
        this.bookRepo = bookRepo;
    }

    @Override
    public BookEntity addBook(BookEntity book)
    {
        Book addBook= toBook(book);
        bookRepo.save(addBook);
        return toBookEntity(addBook);
    }

    @Override
    public BookEntity getBook(int bookId)
    {
        Book book = bookRepo.findById(bookId).get();
        return toBookEntity(book);
    }

    @Override
    public List<BookEntity> getAllBooks()
    {
        List<BookEntity> bookEntities = new java.util.ArrayList<>(List.of());
        List<Book> books = bookRepo.findAll();
        for (Book book : books)
        {
            bookEntities.add(toBookEntity(book));
        }
        return bookEntities;
    }

    @Override
    public BookEntity deleteBook(int bookId)
    {
        Book book = bookRepo.findById(bookId).get();
        bookRepo.deleteById(bookId);
        return toBookEntity(book);
    }
}
