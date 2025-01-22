package com.keorber.customerdao.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class GetConnection
{
    public static Connection connection = null;
    private static final Logger logger = LoggerFactory.getLogger(GetConnection.class);
    public static Connection getConnection() {
        InputStream inputStream = GetConnection.class.getClassLoader().getResourceAsStream("dbconn.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            logger.error(e.getCause().toString());
        }
        String driver=properties.getProperty("jdbc.driver");
        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        // load the class
        try {
            Class.forName(driver);
            // create the connection
            logger.info("diver has been loaded");
            connection = java.sql.DriverManager.getConnection(url, username, password);
            logger.info("connection has been created");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("connection has not been created");
            logger.error(e.getMessage());
            logger.error(e.getCause().toString());
        }
        return connection;
    }

}
