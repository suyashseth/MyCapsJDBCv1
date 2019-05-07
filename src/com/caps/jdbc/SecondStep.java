package com.caps.jdbc;

import java.io.FileReader;
import java.sql.DriverManager;
import java.util.Properties;

public class SecondStep {

	public static void main(String[] args) {
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		
		//2. Estb the connection via Driver
		String path = "C:/Users/QSP/Desktop/Caps_Training/DBCredentials.PROPERTIES";
		FileReader reader = new FileReader(path);
		Properties prop = new Properties();
		prop.load(reader);
		
		String dburl = "jdbc:mysql://localhost:3306/captain_marvel";
		DriverManager.getConnection(dburl,prop);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
		catch(Exception e)
		{
			
		}finally
		{
			
		}
		
		
		
		
		
		
		
		
	}
}
