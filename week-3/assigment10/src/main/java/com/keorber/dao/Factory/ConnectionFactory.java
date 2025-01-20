package com.keorber.dao.Factory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory
{
    static Connection connection = null;
    public static Connection getConnection()
    {
            InputStream inputStream = ConnectionFactory.class.getClassLoader().getResourceAsStream("Collection_material.properties");
            Properties properties = new Properties();
            try
            {
                properties.load(inputStream);
                String driver = properties.getProperty("jdbc.driver");
                System.out.println("Driver intialized successfully");
                String url = properties.getProperty("jdbc.url");
                String username = properties.getProperty("jdbc.username");
                String password = properties.getProperty("jdbc.password");
                connection = DriverManager.getConnection(url, username, password);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        return connection;
    }
}
