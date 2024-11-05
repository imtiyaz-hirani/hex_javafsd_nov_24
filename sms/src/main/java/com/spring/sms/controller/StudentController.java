package com.spring.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.sms.exception.InvalidCredentialsException;
import com.spring.sms.model.Course;
import com.spring.sms.model.User;
import com.spring.sms.service.CourseService;
import com.spring.sms.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService; //DI
	@Autowired
	private CourseService courseService;
	@GetMapping("/")
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/login-form")
	public String handleLogin(HttpServletRequest req, HttpSession session) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		try {
			User user =  studentService.verifyLogin(username,password);
			if(user.getRole().equalsIgnoreCase("student")) {
				session.setAttribute("username", username);
				//fetch all courses
				List<Course> courses =  courseService.fetchAllCourses();
				//List listCourses courseService.fetchAllCourses();
				req.setAttribute("listCourses", courses);
				
				//fetch all enrolled course 
				List<Course> enrolledCourses =  courseService.getEnrolledCourses(session.getAttribute("username"));
				req.setAttribute("enrolledCourses", enrolledCourses);
				
				return "student_dashboard"; 
			} 
		} catch (InvalidCredentialsException e) {
			req.setAttribute("msg",e.getMessage());
			return "login";
		}
		return null; 
	}
	
	@GetMapping("/enroll")
	public String processEnroll(HttpServletRequest req, HttpSession session) {
		String username = (String)session.getAttribute("username"); 
		int cid = Integer.parseInt(req.getParameter("cid"));
		String cname = req.getParameter("cname");
		studentService.enrollInCourse(username,cid); 
		req.setAttribute("cname", cname);
		return "enroll_confirm";
	}
	
	@GetMapping("/student-dashboard")
	public String goToStudentDashboard(HttpServletRequest req,HttpSession session) {
		//fetch all courses
		List<Course> courses =  courseService.fetchAllCourses();
		//List listCourses courseService.fetchAllCourses();
		req.setAttribute("listCourses", courses);
		
		//fetch all enrolled course 
		List<Course> enrolledCourses =  courseService.getEnrolledCourses(session.getAttribute("username"));
		req.setAttribute("enrolledCourses", enrolledCourses);
		return "student_dashboard";
	}
}





