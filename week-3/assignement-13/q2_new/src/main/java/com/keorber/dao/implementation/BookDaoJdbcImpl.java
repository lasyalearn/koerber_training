package com.keorber.dao.implementation;

import com.keorber.dao.BookDao;
import com.keorber.dao.BookRowMapper;
import com.keorber.dao.connection.GetConnection;
import com.keorber.dto.Book;
import com.keorber.expection.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
//dao layer is where u have to wrap the error and then throw it
// <bean id="bookDaoJdbcImpl"  primary="true" class="com.keorber.dao.implementation.BookDaoJdbcImpl"/>
@Repository(value = "bookDaoJdbcImpl")
@Primary
public class BookDaoJdbcImpl implements BookDao
{
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public BookDaoJdbcImpl( JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Connection connection= null;
    @Override
    public Book addBook(Book book)
    {
        //connection = GetConnection.getConnection();
        jdbcTemplate.update("insert into books values(?,?,?,?,?)", new Object[]{book.getId(), book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPrice()});
        return book;


    }

    @Override
    public void updateBook(Book book)
    {
        //connection = GetConnection.getConnection();
        jdbcTemplate.update("update books set title=? where id=?", new Object[]{book.getTitle(), book.getId()});
    }

    @Override
    public List<Book> getAllBooks()
    {
        //connection = GetConnection.getConnection();
        List<Book> books = new LinkedList<>();
        books=jdbcTemplate.query("select * from books", new BookRowMapper());
        return books;
    }

    @Override
    public Book getBook(int id)
    {
        Book book;
        book=jdbcTemplate.queryForObject("select * from books where id=?", new Object[]{id}, new BookRowMapper());
        return book;
    }

    @Override
    public void deleteBook(int id)
    {
        //connection = GetConnection.getConnection();
        jdbcTemplate.update("delete from books where id=?", new Object[]{id});
    }
}
