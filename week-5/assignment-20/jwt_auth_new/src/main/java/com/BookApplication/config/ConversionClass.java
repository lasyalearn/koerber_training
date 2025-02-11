package com.BookApplication.config;

import com.BookApplication.dto.Book;
import com.BookApplication.entites.BookEntity;

public class ConversionClass
{
    public  static BookEntity toBookEntity(Book book)
    {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(book.getId());
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setPrice(book.getPrice());
        return bookEntity;
    }

    public static Book toBook(BookEntity bookEntity)
    {
        Book book = new Book();
        book.setId(bookEntity.getId());
        book.setTitle(bookEntity.getTitle());
        book.setAuthor(bookEntity.getAuthor());
        book.setPrice(bookEntity.getPrice());
        return book;
    }
}
