package com.spring.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.sms.exception.InvalidCredentialsException;
import com.spring.sms.model.User;
import com.spring.sms.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService; //DI
	
	@GetMapping("/")
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/login-form")
	public String handleLogin(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		try {
			User user =  studentService.verifyLogin(username,password);
			if(user.getRole().equalsIgnoreCase("student")) {
				req.setAttribute("username", username);
				return "student_dashboard"; 
			}
		} catch (InvalidCredentialsException e) {
			req.setAttribute("msg",e.getMessage());
			return "login";
		}
		return null; 
	}
}
