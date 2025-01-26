package config;

import com.keorber.dao.BookDao;
import com.keorber.dao.implementation.BookDaoHibernetImpl;
import com.keorber.dao.implementation.BookDaoJdbcImpl;
import com.keorber.service.BookService;
import com.keorber.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//<context:annotation-config></context:annotation-config>
//    <context:component-scan base-package="com.keorber"></context:component-scan>
@Configuration
@ComponentScan(basePackages = "com.keorber")
@EnableAspectJAutoProxy
@EnableTransactionManagement
@PropertySource(value = "classpath:dbconn.properties")
public class app_config
{
    //first is driver manager datasource
    //driverMangement datasource for connection pool
    //what happens here is
    @Autowired
    private Environment env ;
    // we want to add read the property file with the connection factory
    // no gurantee it is singleton
    // there there is a single connection that we can't close
    // that management is upto ue
    // so here we create a datasource
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource)
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }
    @Bean
    public DriverManagerDataSource getDataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource ();
        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }
    // to

    // we use bean when u don't what to pollute the business logic
    // since  jdbc is  important to the business logic
    // we use constructor

    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager()
    {
        return new DataSourceTransactionManager(getDataSource());
    }
    // here spring would inject the data source oject in the datasource transactiona manager
    // and in the jdbcTemplate

}
