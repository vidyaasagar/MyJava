package com.test.jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class TransactionDemo {

	public static void main(String[] args) throws Exception {
		Connection connection =DBUtill.getDBConnection();
	//	PreparedStatement pstmt = connection.prepareStatement("insert into employee values(?,?,?,?)");
	//	for(int i = 1011;i<1100;i++){
		//allows database to save only after all statements are updated.it restricts autosaving
		connection.setAutoCommit(false);
		Statement stmt = connection.createStatement();
		try{
			//most of the time we use the batch for insert/update/delete not for reading
			stmt.addBatch("insert into employee values(2001,'Elena',27,24000);");
			stmt.addBatch("insert into employee values(2002,'Elena',28,25000);");
			stmt.executeBatch();
			connection.commit();//save
		
		}catch(Exception ex){ 
			ex.printStackTrace();
			connection.rollback();//undo
		}
		connection.rollback();
		
		connection.close();
	}
			
		}
		

	
	


