package com.koerber.dao;

import com.koerber.dto.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookStoreDao extends JpaRepository<Book, Integer>
{
//    public List<Book> getAllBooks();
//    public Book addBook(Book book);
//    public void deleteBook(int id);
//    public void updateBook(int id, Book book);
    public Book getBookById(int id);

}
