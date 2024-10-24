package com.sms.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sms.dto.StudentDto;
import com.sms.model.Address;
import com.sms.model.Student;
import com.sms.model.User;
import com.sms.utility.DbConnection;

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

	public List<StudentDto> getAllStudentsInfo() {
		Connection conn = DbConnection.dbConnect();
		List<StudentDto> list = new ArrayList<>();
		String sql="select s.id,s.name,s.contact,a.city,u.username,a.state "
				+ " from student s "
				+ " JOIN address a ON s.address_id = a.id "
				+ " JOIN user u ON s.user_id = u.id";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rst =  pstmt.executeQuery();
			while(rst.next()) {
				StudentDto dto = new StudentDto();
				dto.setId(rst.getInt(1));
				dto.setName(rst.getString(2));
				dto.setContact(rst.getString(3));
				dto.setCity(rst.getString(4));
				dto.setUsername(rst.getString(5));
				dto.setState(rst.getString(6));
				list.add(dto);
			}
		} catch (SQLException e) {
			 e.printStackTrace();
		}

		DbConnection.dbClose();
		return list;
	}

}
