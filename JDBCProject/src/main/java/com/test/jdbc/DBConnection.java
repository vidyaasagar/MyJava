package com.test.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//load driver class
		Class.forName("com.mysql.jdbc.Driver");
		//connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sagar","root","myphone@L99");
		//perform DB operations
		Statement stmt = connection.createStatement();
		int result = stmt.executeUpdate("DELETE FROM emp where emp_id = 18 AND emp_name='Bunny'");
	   boolean result1 = stmt.execute("select * from emp;");
	System.out.println("Rows Deleted :" + result);
		System.out.println("Rows effected in DB : " + result1);
		connection.close();

	}

}
