package com.keorber.dao;

import com.keorber.Exception.DaoException;
import com.keorber.dao.Factory.ConnectionFactory;
import com.keorber.dto.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
// the service and the dao they interact with eachother
// the intertact through the interface an interface
public class BookDaoImp implements BookDao
{
    Connection connection= ConnectionFactory.getConnection();
    // this is the universal connection for all the interactions
    // so we should not close it, or we will get NullPointerException
    @Override
    public List<Book> getAllBooks() throws DaoException, SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from books");
        List<Book> books = new ArrayList<>();
        while(resultSet.next())
        {
            books.add(new Book(resultSet.getInt("id"),resultSet.getString("isbn"),resultSet.getString("title"),resultSet.getString("author"),resultSet.getDouble("price")));
        }
        return books;
    }

    @Override
    public Book addBook(Book book) throws DaoException, SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into books values(?,?,?,?,?)");
        statement.setInt(1,book.getId());
        statement.setString(2,book.getIsbn());
        statement.setString(3,book.getTitle());
        statement.setString(4,book.getAuthor());
        statement.setDouble(5,book.getPrice());
        int no_of_effected_rows =statement.executeUpdate();
        return book;
    }
    // in the method we prefer throws to try chatch
    @Override
    public void deleteBook(int id) throws DaoException, SQLException {
        PreparedStatement statement = connection.prepareStatement("delete from books where id=?");
        statement.setInt(1,id);
        int no_of_effected_rows =statement.executeUpdate();
    }

    @Override
    public void updateBook(int id, Book book) throws DaoException, SQLException {
        PreparedStatement statement = connection.prepareStatement("update books set isbn=?,title=?,author=?,price=? where id=?");
        statement.setString(1,book.getIsbn());
        statement.setString(2,book.getTitle());
        statement.setString(3,book.getAuthor());
        statement.setDouble(4,book.getPrice());
        statement.setInt(5,id);
        int no_of_effected_rows =statement.executeUpdate();
    }

    @Override
    public Book getBookById(int id) throws DaoException, SQLException {
        Book foundBook = null;
        PreparedStatement statement = connection.prepareStatement("select * from books where id=?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next())
        {
            foundBook = new Book(resultSet.getInt("id"),resultSet.getString("isbn"),resultSet.getString("title"),resultSet.getString("author"),resultSet.getDouble("price"));
        }
        return foundBook;
    }


}
