package com.test.jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class DBConnectionV1 {
	
	public static void main(String[] args) throws Exception {
		//Get DB connection
		Connection connection1 = DBUtill.getDBConnection();
		//Get DB connection 
		Connection connection = DBUtill.getDBConnection();
		
		//perform DB operations
		Statement stmt = connection1.createStatement();
		
		int result = stmt.executeUpdate("INSERT INTO emp VALUES (18,'Bunny',28,29000);");
		System.out.println("Rows Effected in DB:" +result);
		connection.close();
		
		
	}

}
//Due to multiple connections objects, properties are loaded every time we make a connection.