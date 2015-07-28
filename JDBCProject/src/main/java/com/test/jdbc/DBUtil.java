package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class DBUtil  {

	public static Connection getDBConnection() throws Exception {
		try {
			//DB properties
			Properties properties = new Properties();
			
			//Load DB properties
			properties.load(DBUtil.class.getResourceAsStream("database.properties"));
			System.out.println(properties);
			
			//load Driver class
			
			Class.forName(properties.getProperty("driverClassName"));
			
			//connection
			Connection connection = DriverManager.getConnection(properties.getProperty("dbUrl"),properties.getProperty("username"),properties.getProperty("password"));
			return connection;
			
			
		}catch(Exception ex) {
			System.out.println("error in DB connection");
			ex.printStackTrace();
		}
		return null;
	}
}


