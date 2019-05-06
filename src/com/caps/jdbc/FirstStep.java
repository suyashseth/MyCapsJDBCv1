package com.caps.jdbc;

import java.sql.DriverManager;

public class FirstStep {

	public static void main(String[] args) {
		
		
		try
		{
			//1.Loads the Driver Class
			java.sql.Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			
			
		}catch(Exception e)
		{
			
		}finally
		{
			
		}
		
		
		
	}
}
