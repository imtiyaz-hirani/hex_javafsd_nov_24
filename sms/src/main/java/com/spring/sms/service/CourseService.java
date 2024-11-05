package com.spring.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.sms.model.Course;
import com.spring.sms.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> fetchAllCourses() {
		 
		return courseRepository.fetchAllCourses();
	}

	public List<Course> getEnrolledCourses(Object usernameObj) {
		String username = (String) usernameObj;
		
		return courseRepository.fetchAllEnrolledCourses(username);
	}

}
