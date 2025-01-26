package com.keorber.dao.implementation;

import com.keorber.dao.BookDao;
import com.keorber.dao.connection.GetConnection;
import com.keorber.dto.Book;
import com.keorber.expection.DaoException;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

//dao layer is where u have to wrap the error and then throw it
/*
*  <bean id="bookDaoHibernetImpl" class="com.keorber.dao.implementation.BookDaoHibernetImpl"/>
* */
//@Repository(value = "bookDaoHibernetImpl")
public class BookDaoHibernetImpl implements BookDao
{

    Connection connection= null;
    @Override
    public Book addBook(Book book)
    {
        connection = GetConnection.getConnection();
        try
        {
            System.out.println("using hibernate");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into books values(?,?,?,?,?)");
            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2, book.getIsbn());
            preparedStatement.setString(3, book.getTitle());
            preparedStatement.setString(4,book.getAuthor());
            preparedStatement.setDouble(5, book.getPrice());
            preparedStatement.executeUpdate();
            return book;
        } catch (SQLException e) {
            throw new DaoException("Enable to add the book",e);
        }


    }

    @Override
    public void updateBook(Book book)
    {
        connection = GetConnection.getConnection();
        try {
            System.out.println("using hibernate");
            PreparedStatement preparedStatement = connection.prepareStatement("update books set title=? where id=?");
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setInt(2, book.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Enable to update the  book",e);
        }

    }

    @Override
    public List<Book> getAllBooks()
    {
        connection = GetConnection.getConnection();
        List<Book> books = new LinkedList<>();
        try
        {
            System.out.println("using hibernate");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from books");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setPrice(resultSet.getDouble("price"));
                books.add(book);
            }
            return books;

        } catch (SQLException e) {
            throw new DaoException("Enable to get all the  books",e);
        }

    }

    @Override
    public Book getBook(int id)
    {
        connection = GetConnection.getConnection();
        try
        {
            System.out.println("using hibernate");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from books where id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setPrice(resultSet.getDouble("price"));
                return book;
            }
        } catch (SQLException e) {
            throw new DaoException("Enable to get book",e);

        }
        return null;
    }

    @Override
    public void deleteBook(int id)
    {
        connection = GetConnection.getConnection();
        try
        {
            System.out.println("using hibernate");
            PreparedStatement preparedStatement = connection.prepareStatement("delete from books where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Enable to delete book",e);
        }
    }
}
