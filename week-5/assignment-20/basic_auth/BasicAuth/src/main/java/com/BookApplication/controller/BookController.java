package com.BookApplication.controller;

import com.BookApplication.entites.BookEntity;
import com.BookApplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController
{
    BookService bookService;
    @Autowired
    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @PreAuthorize("hasAnyAuthority('ROLE_Teacher', 'ROLE_Student')")
    @GetMapping("/books")
    public List<BookEntity> getBooks()
    {
        return bookService.getAllBooks();
    }
    @PreAuthorize("hasAnyAuthority('ROLE_Teacher', 'ROLE_Student')")
    @GetMapping("/books/{bookId}")
    public BookEntity getBook(@PathVariable int bookId)
    {
        return bookService.getBook(bookId);
    }
    @PreAuthorize("hasAnyAuthority('ROLE_Teacher', 'ROLE_Student')")
    @PostMapping("/books/add")
    public BookEntity addBook(@RequestBody BookEntity book)
    {
        return bookService.addBook(book);
    }
    @PreAuthorize("hasAuthority('ROLE_Teacher')")
    @DeleteMapping("/books/delete/{bookId}")
    public void deleteBook(@PathVariable int bookId)
    {
        bookService.deleteBook(bookId);
    }

}
