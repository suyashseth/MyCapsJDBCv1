package com.caps.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ThirdStep {
public static void main(String[] args) {
	
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		
		//1.Step: Loads The Driver Class
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.Step: Estb the connection via Driver
		String path = "C:/Users/QSP/Desktop/Caps_Training/DBCredentials.PROPERTIES";
		FileReader reader = new FileReader(path);
		Properties prop = new Properties();
		prop.load(reader);
		
		String dburl = "jdbc:mysql://localhost:3306/captain_marvel";
		con = DriverManager.getConnection(dburl,prop);
		
		//3 Step: Issue the SQL query via Connection
		String query = "select * from Stone_table";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query);
		
		//Process the result returned by sql query
		while(rs.next())
		{
			int no = rs.getInt("s_no");
			String name1 = rs.getString("Stone_name");
			String color = rs.getString("Stone_color");
			int price = rs.getInt("Stone_price");

			System.out.println(no);
			System.out.println(name1);
			System.out.println(color);
			System.out.println(price);
			System.out.println("***************");

		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		
		
		
	}
	
	
	
}
}
