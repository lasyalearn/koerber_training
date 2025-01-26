package com.keorber.dao.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class GetConnection
{
    public static Connection getConnection()
    {
        Connection connection = null;
        Properties properties = new Properties();
        try
        {
            InputStream inputStream = GetConnection.class.getClassLoader().getResourceAsStream("dbconn.properties");
            properties.load(inputStream);
            String driver = properties.getProperty("jdbc.driver");
            String url = properties.getProperty("jdbc.url");
            String username = properties.getProperty("jdbc.username");
            String password = properties.getProperty("jdbc.password");
            Class.forName(driver);
            connection = java.sql.DriverManager.getConnection(url, username, password);
            return connection;
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
