package com.test.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
//import java.io.FileInputStream;


public class JDBCConnection {
	
	public static void main(String[] args) throws Exception{
	
		//DB properties
		Properties properties = new Properties();
	//	properties.load(new FileInputStream("D:\\Development\\workplace\\JDBCConnection\\resources\\com\\test\\jdbc1\\database.properties"));
		properties.load(JDBCConnection.class.getResourceAsStream("database.properites"));
		
		//load driver class
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName(properties.getProperty("driverClassName"));
		
			//connection
		//	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sagar","root","myphone@L99");
		 
		Connection connection = DriverManager.getConnection(properties.getProperty("dbUrl"), properties.getProperty("username"),properties.getProperty("password"));
		
		//perform DB operations
		Statement stmt = connection.createStatement();
			//int result = stmt.executeUpdate("DELETE FROM employee where id = 3 AND name='sam'");
			boolean result1 = stmt.execute("INSERT INTO employee VALUES(25,'Bunny',28,29000)");
		   // System.out.println("Rows Deleted :" + result);
		System.out.println("Rows effected in DB : " + result1);
			connection.close();
	}
	

}

