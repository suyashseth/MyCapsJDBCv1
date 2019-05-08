package com.caps.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateProfile {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Color ");
	String color = sc.next();
	System.out.println("Enter Sno");
	int sno = sc.nextInt();
	Connection con = null;
	PreparedStatement pstmt = null;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		String dburl = "jdbc:mysql://localhost:3306/captain_marvel?user=root&password=root";
		con = DriverManager.getConnection(dburl);
		
		String query = "Update Stone_table set Stone_Color = ?"
				+ " where s_no = ?";
		pstmt = con.prepareStatement(query);
		pstmt.setString(1,color);
		pstmt.setInt(2,sno);
	    int count = pstmt.executeUpdate();
	    
	    if(count>0)
	    {
	    	System.out.println("Updated");
	    }
	    else
	    {
	    	System.out.println("Ooops Somthing went Wrong");
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
