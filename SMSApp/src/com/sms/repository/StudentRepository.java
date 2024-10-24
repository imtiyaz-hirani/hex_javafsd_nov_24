package com.sms.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sms.model.Address;
import com.sms.model.Student;
import com.sms.model.User;

public class StudentRepository {
 
	public void insertUser(User user, Connection conn) {
		String sql="insert into user(id,username,password,role) values (?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getRole());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertAddress(Address address, Connection conn) {
		String sql="insert into address(id,city,state) values (?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, address.getId());
			pstmt.setString(2, address.getCity());
			pstmt.setString(3, address.getState());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void insertStudent(Student student, Connection conn) {
		String sql="insert into student(id,name,contact,user_id,address_id) values (?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getId());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getContact());
			pstmt.setInt(4, student.getUser().getId());
			pstmt.setInt(5, student.getAddress().getId());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
