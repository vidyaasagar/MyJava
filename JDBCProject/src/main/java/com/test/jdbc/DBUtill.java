package com.test.jdbc;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtill {
   private static Properties dbProperties = new Properties();
   static{
	   try{
		   System.out.println("executing static block...");
		   dbProperties.load(DBUtill.class.getResourceAsStream("database.properties"));
		   System.out.println("loaded DB properties");
		   System.out.println(dbProperties);
	   }catch(IOException ie){
		   System.out.println("failed to load DB properties");
		   ie.printStackTrace();
	   }
   }
	  public static Connection getDBConnection()  {
		  try {
			  //load Driver class
			   Class.forName(dbProperties.getProperty("driverClassName"));
			  //Connection
			   Connection connection = DriverManager.getConnection(dbProperties.getProperty("dbUrl"),dbProperties.getProperty("username"),dbProperties.getProperty("password"));
		       return connection;
		  }catch(Exception ex){
			  System.out.println("something went wrong");
			  
		  }
		  return null;
	  }
		 
	  
   
}

