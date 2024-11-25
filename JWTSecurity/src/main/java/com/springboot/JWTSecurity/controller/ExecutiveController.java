package com.springboot.JWTSecurity.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.JWTSecurity.enums.Department;
import com.springboot.JWTSecurity.enums.JobTitle;
import com.springboot.JWTSecurity.model.Executive;
import com.springboot.JWTSecurity.service.ExecutiveService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class ExecutiveController {

	private ExecutiveService executiveService;
	
	@PostMapping("/executive/add")
	public Executive addExecutive(@RequestBody Executive executive) {
		return executiveService.addExecutive(executive);
	}
	@GetMapping("/department/all")
	public List<Department> getAllDepartments() {
		return Arrays.asList(Department.values());
	}
	@GetMapping("/job-title/all")
	public List<JobTitle> getAllJobTitle() {
		return Arrays.asList(JobTitle.values());
	}
}
