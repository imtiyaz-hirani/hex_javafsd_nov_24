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
		List<Instructor> list = new ArrayList<>();
		try {
			PreparedStatement pstmt =  con.prepareStatement(sql);
			ResultSet rst =  pstmt.executeQuery(sql);
			
			
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
		return list;
	}

	public boolean getInstructorById(int id) {
		Connection con = DbConnection.dbConnect();
		boolean isValid=true; 
		String sql="select * from instructor where id=?";
		try {
			PreparedStatement pstmt =  con.prepareStatement(sql);
			//assign values of ?
			pstmt.setInt(1, id);
			ResultSet rst =  pstmt.executeQuery();
			 isValid = rst.next();
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		DbConnection.dbClose();
		return isValid; 
	}

	public void deleteById(int id) {
		Connection con = DbConnection.dbConnect();
		String sql="delete from instructor where id=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		DbConnection.dbClose();
	}

}
