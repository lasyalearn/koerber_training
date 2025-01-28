package com.koerber.controller;

import com.koerber.dto.Book;
import com.koerber.service.BookStoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/api")
public class BookStoreController
{

    //Response Entity
    // HttpStatus code
    BookStoreService bookStoreService;
    @Autowired
    //write is autowired is not compulsary for single function
    public BookStoreController(BookStoreService bookStoreService)
    {
        this.bookStoreService = bookStoreService;
    }

    //get all books
    @GetMapping(path = "books")
    public ResponseEntity<List<Book>> getAllBooks()
    {
        return ResponseEntity.status(HttpStatus.OK).body(bookStoreService.getAllBooks());
    }

    //get book by id
    @GetMapping(path = "book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id)
    {
        //return bookStoreService.getBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookStoreService.getBookById(id));
    }

    //add a book
    @PostMapping(path = "addbook")
    public ResponseEntity<Book> addBook(@RequestBody @Valid Book book)
    {
        //return bookStoreService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookStoreService.addBook(book));
    }

    //update a book
    @PutMapping(path = "updatebook/{id}")
    public void updateBook(@PathVariable int id, @RequestBody @Valid Book book)
    {
        bookStoreService.updateBook(id, book);
        ResponseEntity.status(HttpStatus.OK).build();
    }

    //delete a book
    @DeleteMapping(path = "deletebook/{id}")
    public void deleteBook(@PathVariable int id)
    {
        bookStoreService.deleteBook(id);
        ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }





//     //get all books
//    @GetMapping(path = "books")
//    public List<Book> getAllBooks()
//    {
//        return bookStoreService.getAllBooks();
//    }
//
//    //get book by id
//    @GetMapping(path = "book/{id}")
//    public Book getBookById(@PathVariable int id)
//    {
//        return bookStoreService.getBookById(id);
//    }
//
//    //add a book
//    @PostMapping(path = "addbook")
//    public Book addBook(@RequestBody Book book)
//    {
//        return bookStoreService.addBook(book);
//    }
//
//    //update a book
//    @PutMapping(path = "updatebook/{id}")
//    public void updateBook(@PathVariable int id, @RequestBody Book book)
//    {
//        bookStoreService.updateBook(id, book);
//    }
//
//    //delete a book
//    @DeleteMapping(path = "deletebook/{id}")
//    public void deleteBook(@PathVariable int id)
//    {
//        bookStoreService.deleteBook(id);
//    }
}
