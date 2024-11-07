package com.sofi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//A singleton class to manage the database connection

public class DB {
	
	public Connection connection;

	// Create object of DB
	private static DB db = new DB();

	private DB() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/zumba";// Database path
			String user = "root";
			String password = "root";
			connection = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// insert , update , delete
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

	public static DB getDB() {
		return db;
	}

	public void closeConnection() {
		try {
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}