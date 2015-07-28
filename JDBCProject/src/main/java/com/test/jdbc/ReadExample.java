package com.test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadExample {

	public static void main(String[] args) throws Exception {
		// Get DB connection
		Connection connection = DBUtill.getDBConnection();
		PreparedStatement pstmt=connection.prepareStatement("SELECT * FROM sagar.emp");
		//PreparedStatement pstmt=connection.prepareStatement("SELECT * FROM emp where eno=?");
		//pstmt.setInt(1,15);
		ResultSet rs= pstmt.executeQuery();
		/*
		 if(rs.next()){
		 System.out.println("Sno"+rs.getInt("sno"));
			System.out.println("col2");
			System.out.println("col3");
			System.out.println("col4");
			System.out.println("=============================================");
		 
		 }
		 else{
		 sysout("Not Found......");
		 }
		 * */
		//if you are expecting multiple records the use while
		while(rs.next()){
			System.out.println("sno   "+rs.getInt("emp_id"));
			System.out.println("sname  "+rs.getString("emp_name"));
			System.out.println("sage    "+rs.getInt("emp_age"));
			System.out.println("ssal    "+rs.getInt("emp_sal"));
			System.out.println("=============================================");
		}
		

	}

}
