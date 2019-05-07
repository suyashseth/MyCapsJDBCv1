package com.caps.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {

		Connection con = null;
		Statement stmt  = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of class");
		String name = sc.next();
		//		System.out.println("Enter username");
		//		String user = sc.next();
		//		System.out.println("Enter password");
		//		String pass = sc.next();
		try
		{
			/*
			 * //1.Loads the Driver Class java.sql.Driver driver = new
			 * com.mysql.jdbc.Driver(); DriverManager.registerDriver(driver);
			 */

			java.sql.Driver d = (java.sql.Driver)Class.forName
					(name).newInstance();
			DriverManager.registerDriver(d);

			//2. Estb the connection via Driver
			String path = "C:/Users/QSP/Desktop/Caps_Training/DBCredentials.PROPERTIES";
			FileReader reader = new FileReader(path);
			Properties prop = new Properties();
			prop.load(reader);

			String dburl = "jdbc:mysql://localhost:3306/captain_marvel";
			con = DriverManager.getConnection(dburl,prop);


			//3.Issue the sql query via connection
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

		}finally
		{


		}
	}








}	




