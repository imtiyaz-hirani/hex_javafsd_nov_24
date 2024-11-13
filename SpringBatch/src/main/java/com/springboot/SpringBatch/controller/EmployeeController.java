package com.springboot.SpringBatch.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.SpringBatch.service.AddressService;
import com.springboot.SpringBatch.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/api/employee/batch-insert")
	public ResponseEntity<?> uploadEmployeethruExcel(@RequestBody MultipartFile file) {
		//System.out.println(file.getOriginalFilename());
		//System.out.println(file.getName());
		try {
			employeeService.uploadEmployeethruExcel(file);
			return ResponseEntity.ok("Records inserted in DB using Sprig Batch"); 
		} catch (IOException e) {
			 return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@DeleteMapping("/api/employee/delete/batch")
	public void deleteEmployeeInBatch(@RequestParam String city) {
		employeeService.deleteEmployeeByCity(city);
	}
	
}
