//package com.keorber.dao.factory;
//
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
////import static com.mysql.cj.conf.PropertyKey.logger;
//
//public class GetConnection {
//    public static Connection connection = null;
//    private static final Logger logger = LoggerFactory.getLogger(GetConnection.class);
//    public static Connection getConnection() {
//        InputStream inputStream = GetConnection.class.getClassLoader().getResourceAsStream("dbconn.properties");
//        Properties properties = new Properties();
//        try {
//            properties.load(inputStream);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String driver = properties.getProperty("jdbc.driver");
//        String url = properties.getProperty("jdbc.url");
//        String username = properties.getProperty("jdbc.username");
//        String password = properties.getProperty("jdbc.password");
////        try
//        {
//            Class.forName(driver);
//            logger.info("Driver loaded");
//            connection = DriverManager.getConnection(url, username, password);
//            logger.info("Database connected");
//            return connection;
//        } catch (ClassNotFoundException | SQLException e)
//        {
//            throw new RuntimeException(e);
//        }
//    }
//}
