package com.BookApplication.controller;

import com.BookApplication.dto.AuthRequest;
import com.BookApplication.entites.BookEntity;
import com.BookApplication.service.BookService;
import com.BookApplication.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthRequest authRequest)
    {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        }else {
            throw  new UsernameNotFoundException("user is invalid");
        }

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


//    @PreAuthorize("hasAuthority('ROLE_Teacher')")
//    @DeleteMapping("/books/delete/{bookId}")
//    public void deleteBook(@PathVariable int bookId)
//    {
//        bookService.deleteBook(bookId);
//    }
@PreAuthorize("hasAnyAuthority('ROLE_Teacher', 'ROLE_Student')")
@DeleteMapping("/api/books/delete/{id}")
public ResponseEntity<?> deleteBook(@PathVariable int id) {
    bookService.deleteBook(id);
    return ResponseEntity.ok().build();
}


}
