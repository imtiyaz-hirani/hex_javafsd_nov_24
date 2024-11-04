package com.spring.sms.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.sms.exception.InvalidCredentialsException;
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

}
