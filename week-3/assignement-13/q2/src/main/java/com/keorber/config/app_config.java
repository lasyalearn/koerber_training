package com.keorber.config;

import com.keorber.dao.BookDao;
import com.keorber.dao.implementation.BookStoreDaoJDBCImpl;
import com.keorber.service.BookService;
import com.keorber.service.BookServiceImp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.keorber")
@EnableAspectJAutoProxy
@PropertySource(value={"classpath:dbconn.properties"})
public class app_config
{
    @Value(("${jdbc.driver}"))
    private String driver;

    @Value(("${jdbc.url}"))
    private String url;

    @Value(("${jdbc.username}"))
    private String username;

    @Value(("${jdbc.password}"))
    private String password;


    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }
    @Bean
    public BookDao bookDao(DataSource dataSource)
    {
        return new BookStoreDaoJDBCImpl(dataSource);
    }

    @Bean(name = "bookService")
    public BookService bookServiceImp(BookDao dao)
    {
        return new BookServiceImp(dao);
    }
}
