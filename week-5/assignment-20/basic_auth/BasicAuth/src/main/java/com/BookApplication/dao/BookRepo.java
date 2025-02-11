package com.BookApplication.dao;

import com.BookApplication.dto.Book;
import com.BookApplication.entites.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>
{

}
