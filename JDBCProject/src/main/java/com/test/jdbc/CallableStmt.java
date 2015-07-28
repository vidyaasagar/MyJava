package com.test.jdbc;


import java.sql.CallableStatement;
import java.sql.Connection;

public class CallableStmt {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Connection connection = DBUtill.getDBConnection();
		CallableStatement cstmt= connection.prepareCall("{call addStudent(?,?,?,?)}");
		cstmt.setInt(1,777);
		cstmt.setString(2,"Ravi");
		cstmt.setString(3,"MS");
		cstmt.setInt(4,7770);
		int result= cstmt.executeUpdate();
		System.out.println("Rows Effected " +result);
		

	}

}
