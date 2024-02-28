package com.wallet.app.ConnectionDatabase;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Configuration
public class ConfigurationDatabase {
    @Value("${spring.datasource.url}")
    private static String dbUrl;

    @Value("${spring.datasource.username}")
    private static String dbUsername;

    @Value("${spring.datasource.password}")
    private static String dbPassword;







    private static final String URL = System.getenv("url");
    private static final String USER = System.getenv("user");
    private static String PASSWORD = System.getenv("password");
    @Bean
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);

    }
}
