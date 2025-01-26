package com.keorber.service;

import com.keorber.dao.BookDao;
import com.keorber.dao.implementation.BookDaoHibernetImpl;
import com.keorber.dto.Book;
import com.keorber.expection.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
// SERVICE LAYER LOOKS SIMILAR TO THE DAO LAYER
// ALL THE NON-FUNCTIONAL REQUIREMENTS ARE PLACED HERE
// ALL THE CROSS CUTTING CONCERNS ARE PLACED HERE
// where time u  make changes int he dao layer then u have to make changes in the service layer
// <bean id="bookService" class="com.keorber.service.BookServiceImpl" autowire="byType">
@Service("bookService")
public class BookServiceImpl implements BookService
{
    //BookDao bookDao = new BookDaoHibernetImpl();
    BookDao bookDao;
    @Autowired
    public BookServiceImpl(BookDao bookDao)
    {
        this.bookDao = bookDao;
    }

    //@Autowired
    //public void setBookDao(BookDao bookDao)
    {
        this.bookDao = bookDao;
    }
    // we are going to give the spring the implementation
    // we remove the intialization and put a setter

    //HERE IS WHERE THE SERVICE LAYER INTERACTS WITH THE DAO LAYER
    //THERE IS COUPLING
    // BUT IF U WANT TO CHANGE THE LAYER THEN YOU HAVE TO CHANGE THE SERVICE LAYER
    //WHICH IS BAD
    @Override
    public Book addBook(Book book)
    {
        return bookDao.addBook(book);
    }

    @Override
    public void updateBook(Book book)
    {
        bookDao.updateBook(book);

    }
    @Loggable
    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public Book getBook(int id)
    {
        Book book = bookDao.getBook(id);
        if(Objects.nonNull(book))
        {
            return book;
        }
        else
        {
            throw new BookNotFoundException("Book not found");
        }
    }

    @Override
    public void deleteBook(int id)
    {
        bookDao.deleteBook(id);

    }


}
