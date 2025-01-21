package com.keorber.service;

import com.keorber.dto.Book;
import com.keorber.exception.BookNotFoundError;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class BookServiceImplTest {

    private BookServiceImpl bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookServiceImpl();
    }

    @Test
    void testGetAllBooks() {
        List<Book> books = bookService.getAllBooks();
        assertNotNull(books, "The list of books should not be null");
    }
    @Test
    void testAddBook() {
        Book book = new Book(3, "S003","Mercury gate", "Tom", 600);
        Book addedBook = bookService.addBook(book);
        assertNotNull(addedBook, "The added book should not be null");
        assertEquals(book.getId(), addedBook.getId(), "The book ID should match");
    }
    @Test
    void testGetBookById() {
        int bookId = 1;
        Book fetchedBook = bookService.getBookById(bookId);
        assertNotNull(fetchedBook, "The fetched book should not be null");
        assertEquals(bookId, fetchedBook.getId(), "The book ID should match");
    }
    @Test
    void testGetBookById_NotFound() {
        int invalidBookId = 999;
        assertThrows(BookNotFoundError.class, () -> bookService.getBookById(invalidBookId),
                "Fetching a non-existing book should throw BookNotFoundError");
    }
    @Test
    void testUpdateBook() {
        int bookId = 1;
        Book updatedBook = new Book(bookId,"S001" ,"infios_new", "koerber_new", 350);
        bookService.updateBook(bookId, updatedBook);

        Book fetchedBook = bookService.getBookById(bookId);
        assertNotNull(fetchedBook, "The updated book should not be null");
        assertEquals("infios_new", fetchedBook.getTitle(), "The title should be updated");
        assertEquals("koerber_new", fetchedBook.getAuthor(), "The author should be updated");
    }
@Test
void testDeleteBook() {
    int bookId = 1;

    bookService.deleteBook(bookId);
    assertThrows(BookNotFoundError.class, () -> bookService.getBookById(bookId),
            "Fetching a deleted book should throw BookNotFoundError");
}
    @AfterEach
    void closeUp() {
        bookService = null;
    }
}





