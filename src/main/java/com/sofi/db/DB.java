package com.sofi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    // Singleton instance
    private static DB db = new DB();

    private DB() {
        try {
        	
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("[DB] Driver Loaded!!!");
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Lazy initialization of singleton
    public static DB getDB() {
        return db;
    }

    // Method to get a new connection for each call
    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/zumba";
        String user = "root";
        String password = "root";
        return DriverManager.getConnection(url, user, password);
    }
}
