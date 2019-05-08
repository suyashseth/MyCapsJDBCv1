package com.caps.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableTest {

	public static void main(String[] args) {
		
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			String dburl = "jdbc:mysql://localhost:3306/captain_marvel?user=root&password=root";
			con = DriverManager.getConnection(dburl);
		    
			String query = "call getAllStone()";
			cstmt = con.prepareCall(query);
			boolean b = cstmt.execute();
			
			if(b)
			{
				rs = cstmt.getResultSet();
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
			}
			else
			{
				int count = cstmt.getUpdateCount();
				if(count>0)
				{
					
				}else
				{
					
				}
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(cstmt!=null)
			{
				try {
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
		
		
	}
}
