package com.caps.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class DynamicSelect {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the serial_num");
	int sno = sc.nextInt();
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
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
		
		String query = "select * from Stone_table where s_no = ?";
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1,sno);
		rs = pstmt.executeQuery();
		
		
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

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
	catch(Exception e)
	{
		
	}
	finally
	{
		
	}
}
}