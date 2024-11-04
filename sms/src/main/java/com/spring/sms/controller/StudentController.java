package com.spring.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.sms.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService; //DI
	
	@GetMapping("/")
	public String showLogin() {
		return "login";
	}
}
