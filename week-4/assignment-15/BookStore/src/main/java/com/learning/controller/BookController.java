package com.learning.controller;

import com.learning.dto.Book;
import com.learning.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    // get all books
    @GetMapping("books")
    public ResponseEntity<List<Book>> getAllBooks()
    {
        //return bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    // get book by id
    @GetMapping("books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(id));
    }

    // add book
    @PostMapping("books/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(book));
    }

    // update book
    @PutMapping("books/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book)
    {
        bookService.updateBook(id, book);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // delete book
    @DeleteMapping("books/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id)
    {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
