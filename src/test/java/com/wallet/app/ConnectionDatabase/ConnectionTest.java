package com.wallet.app.ConnectionDatabase;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {
    public static void connectionDBTest(){
        System.out.println("\n=====DATABASE CONNECTION TEST=====");
        try (Connection connection = ConfigurationDatabase.getConnection()) {
            System.out.println("==> succes:" + " Connection réussite");
        } catch (SQLException e) {
            System.out.println("==> error: " + e.getMessage());
        }
        System.out.println("-------------------------------");
    }

}
