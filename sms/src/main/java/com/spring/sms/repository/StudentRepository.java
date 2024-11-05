package com.spring.sms.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.sms.exception.InvalidCredentialsException;
import com.spring.sms.model.Student;
import com.spring.sms.model.User;

@Repository
public class StudentRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User verifyLogin(String username, String password) throws InvalidCredentialsException {
		 String sql="select * from User where username=? and password=?";
		 PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override 
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql); 
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				return pstmt;
			}
		};
		 List<User> list =  jdbcTemplate.query(psc, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User(); 
				user.setId(rs.getInt("id"));
				user.setUsername(username);
				user.setPassword(password);
				user.setRole(rs.getString("role"));
				return user;
			}
			
		 });
		 if(list.isEmpty()) {
			 throw new InvalidCredentialsException("Invalid Credentials");
		 }
		 else
		 return list.get(0);
	}

	public int getStudentByUsername(String username) {
		String sql="select s.id from student s "
				+ "	JOIN user u ON s.user_id = u.id "
				+ "	where u.username=?";
		
		Object[] obj= new Object[] {username};
		int sid = jdbcTemplate.queryForObject(sql, Integer.class, obj);
		return sid;
	}

	public void enrollInCourse(int sid, int cid) {
		String sql="insert into student_course values(?,?,?)";
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override 
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				 PreparedStatement pstmt =   con.prepareStatement(sql);
				 pstmt.setInt(1, sid);
				 pstmt.setInt(2, cid);
				 pstmt.setString(3, LocalDate.now().toString());
				 
				return pstmt;
			}
			
		};
		jdbcTemplate.update(psc);
		
	}

}
