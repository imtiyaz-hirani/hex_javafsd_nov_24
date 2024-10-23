package com.sms.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sms.model.Instructor;
import com.sms.utility.DbConnection;

public class InstructorRepository {

	public void insert(Instructor instructor)  {
		//connect to DB
		Connection con = DbConnection.dbConnect();
		//query
		String sql="insert into instructor(name,contact,salary,job_title) values (?,?,?,?)";
		try {
		//prepare the statement 
		PreparedStatement pstmt =  con.prepareStatement(sql);
		//assign values of ?
		pstmt.setString(1, instructor.getName());
		pstmt.setString(2, instructor.getContact());
		pstmt.setDouble(3, instructor.getSalary());
		pstmt.setString(4, instructor.getJobTitle());
		
		//run the statement
		pstmt.executeUpdate();
		//close connection
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		DbConnection.dbClose();
	}

}
