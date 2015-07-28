package com.test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PreparedStmtExample {
	
	public static void main(String[] args) throws Exception{
		
		Connection connection = DBUtill.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("INSERT INTO emp VALUES(?,?,?,?)");
		for(int i=1000;i<1100;i++){
			pstmt.setInt(1,i);
			pstmt.setString(2,"Tim"+i);
			pstmt.setString(3,"MS");
			pstmt.setInt(4,(i+2000));
			pstmt.executeUpdate();
		
		}
		connection.close();
	}

}
