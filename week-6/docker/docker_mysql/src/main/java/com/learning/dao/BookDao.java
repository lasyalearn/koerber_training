package com.learning.dao;

import com.learning.dto.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer>
{

    public Book getBookById(int id);

}
