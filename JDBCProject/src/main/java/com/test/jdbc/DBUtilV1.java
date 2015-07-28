package com.test.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtilV1 {

	//DB Properties
	private static Properties dbProperties = new Properties();
	
	//Data Source
	private static DataSource mySQLDS = null;
	
	static{
		try{
			//B.L
			System.out.println("Executing Static block .....");
			
			//Load DB Properties
			dbProperties.load(DBUtilV1.class.getResourceAsStream("database.properites"));
			
			
			System.out.println(" Loaded DB properties!!!!");
			System.out.println(dbProperties);
			setUPDatasource();
		}catch(IOException ie){
			System.out.println("Failed load DB Properties !!!!...");
			ie.printStackTrace();
		}
		
	}
	//using this method from Apache we are pre creating connection objects needed for our applications(connection pooling)
	private static void setUPDatasource(){
		BasicDataSource basicDS = new BasicDataSource();
		basicDS.setUrl(dbProperties.getProperty("dbUrl"));
		basicDS.setPassword(dbProperties.getProperty("password"));
		basicDS.setUsername(dbProperties.getProperty("username"));
		basicDS.setDriverClassName(dbProperties.getProperty("driverClassName"));
		mySQLDS = basicDS;
	}
	
	public static Connection getDBConnection(){
		try{
			return mySQLDS.getConnection();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
