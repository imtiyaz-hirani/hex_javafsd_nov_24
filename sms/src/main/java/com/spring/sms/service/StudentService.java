package com.spring.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.sms.exception.InvalidCredentialsException;
import com.spring.sms.model.Student;
import com.spring.sms.model.User;
import com.spring.sms.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public User verifyLogin(String username, String password) throws InvalidCredentialsException {
		
		return studentRepository.verifyLogin(username,password);
	}

	public void enrollInCourse(String username, int cid) {
		int sid =  studentRepository.getStudentByUsername(username);
		studentRepository.enrollInCourse(sid, cid); 
	}
}
