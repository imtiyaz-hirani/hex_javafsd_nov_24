package com.sms.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DbConnection {
	
	static Connection con; 
	
	public static Connection dbConnect() {
		/*
		 * Load the driver 
		*/
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("driver loaded");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		/*
		 * Establish the connection 
		*/
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fsd_oct_sms_db", "root", "techskillsit");
				System.out.println("Connection est...");
			} catch (SQLException e) {
				 e.printStackTrace();
			}
			return con; 
	}
	
	public static void dbClose() {
		/* Close the connection */
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//
//	public static void main(String[] args) {
//		DbConnection.dbConnect();
//		DbConnection.dbClose();
//		
//	}
}
//ctrl + shft + o
