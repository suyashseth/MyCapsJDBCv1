package com.caps.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo {
public static void main(String[] args) {
	
	Connection con = null;
	Statement stmt  = null;
	ResultSet rs = null;
	try
	{
	//1. Loads the Driver Class
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	
	//2.Estb the db Connection via Driver
	String dburl = "jdbc:mysql://localhost:3306/captain_marvel?user=root&password=root";
	con = DriverManager.getConnection(dburl);
	
	//3.Issue the sql query via connection
	String query = "select * from Stone_table";
	stmt = con.createStatement();
	rs = stmt.executeQuery(query);
	
	//Process the result returned by sql query
	while(rs.next())
	{
		int no = rs.getInt("s_no");
		String name = rs.getString("Stone_name");
		String color = rs.getString("Stone_color");
		int price = rs.getInt("Stone_price");
		
		System.out.println(no);
		System.out.println(name);
		System.out.println(color);
		System.out.println(price);
		System.out.println("***************");
		
	}
	
	}catch(Exception e)
	{
		e.printStackTrace();
		
	}finally
	{
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}