package com.keorber.config;

import com.keorber.dao.BookDao;
import com.keorber.dao.implementation.BookDaoImp;
import com.keorber.service.BookService;
import com.keorber.service.BookServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.keorber")
public class app_config
{
    @Bean
    public BookDao bookDaoImp()
    {
        return new BookDaoImp();
    }

    @Bean(name = "bookService")
    public BookService bookServiceImp(BookDao dao)
    {
        return new BookServiceImp(dao);
    }
}
