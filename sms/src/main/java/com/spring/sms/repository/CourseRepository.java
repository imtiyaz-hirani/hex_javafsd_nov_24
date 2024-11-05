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

import com.spring.sms.model.Course;
import com.spring.sms.model.Department;

@Repository
public class CourseRepository {

	@Autowired
	private JdbcTemplate jdbc; 
	
	public List<Course> fetchAllCourses() {
		//prepare the statement 
		String sql="select c.id as course_id, c.name as course_name, "
				+ "	c.credits, d.name as d_name "
				+ "	from course c join department d ON c.department_id=d.id where c.is_active=?";
		
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt =  con.prepareStatement(sql);
				pstmt.setBoolean(1, true);
				return pstmt;
			}
			
		};
		
		RowMapper<Course> rowMapper = new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course(); 
				int courseId = rs.getInt("course_id");
				String courseName = rs.getString("course_name");
				String credits = rs.getString("credits");
				String dName = rs.getString("d_name");
				
				course.setId(courseId);
				course.setName(courseName);
				course.setCredits(credits);
				
				Department dept = new Department(); 
				dept.setName(dName);
				
				course.setDepartment(dept);
				
				return course;
			}
			
		};
		
		List <Course> list = jdbc.query(psc, rowMapper);
		 
		return list;
	}

	public List<Course> fetchAllEnrolledCourses(String username) {
		String sql="select c.* "
				+ " from student s JOIN student_course sc ON s.id=sc.student_id "
				+ " JOIN course c ON sc.course_id = c.id "
				+ " JOIN user u ON s.user_id= u.id "
				+ " where u.username=?";
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt =  con.prepareStatement(sql);
				pstmt.setString(1, username);
				return pstmt;
			}
			
		};
		
		RowMapper<Course> rowMapper = new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course(); 
				int courseId = rs.getInt("id");
				String courseName = rs.getString("name");
				String credits = rs.getString("credits");
				
				course.setId(courseId);
				course.setName(courseName);
				course.setCredits(credits);
				 
				return course;
			}
			
		};
		List <Course> list = jdbc.query(psc, rowMapper);
		return list;
	}

	public void softDelete(int cid) {
		String sql="update course set is_active=false where id=?";
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt =  con.prepareStatement(sql);
				pstmt.setInt(1, cid);
				return pstmt;
			}
			
		};
		jdbc.update(psc);
	}

}



