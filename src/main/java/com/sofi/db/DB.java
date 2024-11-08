package com.sofi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//A singleton class to manage the database connection

public class DB {
	
	public Connection con;

	// Create object of DB: Singleton instance
	private static DB db = new DB();

	private DB() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("[DB] Driver Loaded!!!");
			
			String url = "jdbc:mysql://localhost:3306/zumba";// Database path
			String user = "root";
			String password = "root";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("[DB] Connection Created!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Lazy initialization of the singleton instance
    public static DB getDB() {
        if (db == null) {
            db = new DB();
        }
        return db;
    }
	
	// Execute insert , update , delete
	public int executeUpdate(PreparedStatement statement) {
		int result = 0;

		try {
			result = statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public ResultSet executeQuery(PreparedStatement statement) {
		ResultSet set = null;

		try {
			set = statement.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return set;
	}

	

	//Close Connection
	public void closeConnection() {
		try {
			con.close();
			System.out.println("[DB] Connection Closed!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}