package com.caps.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class DynamicQuery {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		
		try
		{
			//1.Step: Loads The Driver Class
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.Step: Estb the connection via Driver
			String path = "C:/Users/QSP/Desktop/Caps_Training/DBCredentials.PROPERTIES";
			FileReader reader = new FileReader(path);
			Properties prop = new Properties();
			prop.load(reader);
			
			String dburl = "jdbc:mysql://localhost:3306/captain_marvel";
			con = DriverManager.getConnection(dburl,prop);
			
			String query = "insert into Stone_table values(3,'Time_Stone','Green',30)";
			stmt = con.createStatement();
			int count = stmt.executeUpdate(query);
			
			if(count>0)
			{
			    System.out.println("Data Added");	
			}
			else
			{
			    System.err.println("Something went wrong");		
			}
			
			
			
		}catch(Exception e)
		{
			
		}
		finally
		{
			
		}
		
		
	}
}
