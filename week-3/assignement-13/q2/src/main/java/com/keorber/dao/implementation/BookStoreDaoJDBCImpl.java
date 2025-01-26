package com.keorber.dao.implementation;

import com.keorber.dao.BookDao;

import com.keorber.dto.Book;
import com.keorber.exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository("bookDao")
public class BookStoreDaoJDBCImpl implements BookDao
{
    private static final Logger logger = LoggerFactory.getLogger(BookStoreDaoJDBCImpl.class);
    private DataSource dataSource;
    @Autowired
    public BookStoreDaoJDBCImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public List<Book> getAllBooks() throws DaoException, SQLException {
        Connection connection = dataSource.getConnection();
        logger.info("BookStoreDaoJDBCImpl");
        logger.info("getAllBooks");
        List<Book> books = new LinkedList<>();
        try
        {

            PreparedStatement ps = connection.prepareStatement("select * from books");
            //ps.executeQuery().
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                books.add(new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getDouble("price")));
            }
        }
        catch (SQLException e)
        {
            throw new DaoException("Couldn't get all the books",e);
        }
        return books;
    }

    @Override
    public Book addBook(Book book) throws DaoException
    {
        logger.info("BookStoreDaoJDBCImpl");
        logger.info("addBook");
        try
        {
            Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into books(id,isbn, title, author, price) values(?,?, ?, ?, ?)");
            ps.setInt(1, book.getId());
            ps.setString(2, book.getIsbn());
            ps.setString(3, book.getTitle());
            ps.setString(4, book.getAuthor());
            ps.setDouble(5, book.getPrice());
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new DaoException("Couldn't add the books",e);
        }

        return book;
    }

    @Override
    public void deleteBook(int id) throws DaoException
    {
        logger.info("BookStoreDaoJDBCImpl");
        logger.info("deleteBook");
        try
        {
            Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from books where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Couldn't delete the books",e);
        }

    }

    @Override
    public void updateBook(int id, Book book) throws DaoException
    {
        logger.info("BookStoreDaoJDBCImpl");
        logger.info("updateBook");
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement("update books set isbn = ?, title = ?, author = ?, price = ? where id = ?");
            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setDouble(4, book.getPrice());
            ps.setInt(5, id);
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new DaoException("Couldn't update the books",e);
        }
    }

    @Override
    public Book getBookById(int id) throws DaoException
    {

        logger.info("BookStoreDaoJDBCImpl");
        logger.info("getBookById");
        try
        {
            Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from books where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                return new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getDouble("price"));
            }
        } catch (SQLException e)
        {
            throw new DaoException("Couldn't get the book",e);
        }
        return null;
    }

}