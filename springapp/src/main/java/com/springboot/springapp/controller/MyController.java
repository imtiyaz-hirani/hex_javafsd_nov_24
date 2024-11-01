package com.springboot.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.springapp.service.MyService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	@Autowired
	private MyService myService;   //DI 
	
	@GetMapping("/")   //@RequestMapping 
	public String showLogin() {
		// System.out.println("login method in controller called....");
		return "login";
	}
	
	@GetMapping("/login-form")
	public String readLogin(HttpServletRequest req) { //DI type 2
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username+ "=============" + password);
		return "dashboard";
	}
}
