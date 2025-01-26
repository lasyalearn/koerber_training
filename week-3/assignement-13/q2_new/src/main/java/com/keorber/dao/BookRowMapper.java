package com.keorber.dao;

import com.keorber.dto.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book>
{

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        return new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getDouble("price"));
    }
}
