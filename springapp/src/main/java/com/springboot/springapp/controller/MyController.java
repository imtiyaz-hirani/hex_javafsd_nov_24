package com.springboot.springapp.controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.springapp.exception.InvalidCredentialsException;
import com.springboot.springapp.model.User;
import com.springboot.springapp.service.MyService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	@Autowired
	private MyService myService;   //DI 
	
	@GetMapping("/")   //@RequestMapping 
	public String showLogin() {
		// System.out.println("login method in controller called....");
		
		return "jsp_demo";
	}
	
	@GetMapping("/login-form")
	public String readLogin(HttpServletRequest req) { //DI type 2
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		try {
			User user = myService.isValid(username,password);
			return "dashboard";
		} catch (InvalidCredentialsException e) {
			req.setAttribute("msg", e.getMessage()); 
			 return "login"; 
		}
		
	}
}
