package com.springboot.springapp.controller;

 
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.springapp.exception.InvalidCredentialsException;
import com.springboot.springapp.model.User;
import com.springboot.springapp.service.MyService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	@Autowired
	private MyService myService;   //DI 
	
	@GetMapping("/")   
	public ModelAndView showLogin(
			Model model, 
			HttpServletRequest httpServletRequest,
			ModelAndView mav) {
		model.addAttribute("username", "harry@gmail.com");
		
		List<String> listSports = Arrays.asList("Chess", "Cricket","Badminton");
		httpServletRequest.setAttribute("list", listSports);
		 
		mav.setViewName("jsp_demo");
		mav.addObject("current_date", LocalDate.now());
		
		return mav;
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
