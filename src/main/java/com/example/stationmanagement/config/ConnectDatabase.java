package com.example.stationmanagement.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    public static void main(String[] args) {
        String url = System.getenv("URL");
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Connection unsuccessful!");
        }
    }
}
