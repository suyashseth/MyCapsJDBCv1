package com.caps.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class CreateProfile {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter sno");
		int sno = sc.nextInt();
		System.out.println("Enter Name of Stone");
		String name = sc.next();
		System.out.println("Enter Color of Stone");
		String color = sc.next();
		System.out.println("Enter price in billion");
		int price = sc.nextInt();
		Connection con = null;
		PreparedStatement pstmt = null;
		
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
			
			String query = "insert into Stone_table values(?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,sno);
			pstmt.setString(2,name);
			pstmt.setString(3,color);
			pstmt.setInt(4,price);
			
			int count = pstmt.executeUpdate();
			if(count>0)
			{
				System.err.println("Data Added");
			}
			else
			{
				System.out.println("Something went wrong");
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}catch(Exception e)
		{
			
		}
		finally
		{
			
		}
	} 
}
