package com.sms.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<Instructor> getAllInstructors() {
		Connection con = DbConnection.dbConnect();
		String sql="select * from instructor";
		 
		try {
			PreparedStatement pstmt =  con.prepareStatement(sql);
			ResultSet rst =  pstmt.executeQuery(sql);
			
			List<Instructor> list = new ArrayList<>();
			while(rst.next()) {
				Instructor instructor = new Instructor();
				instructor.setId(rst.getInt("id"));
				instructor.setName(rst.getString("name"));
				instructor.setSalary(rst.getDouble("salary"));
				instructor.setContact(rst.getString("contact"));
				instructor.setJobTitle(rst.getString("job_title"));
				list.add(instructor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		DbConnection.dbClose();
		return null;
	}

}
