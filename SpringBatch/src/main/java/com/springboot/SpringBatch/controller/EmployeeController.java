package com.springboot.SpringBatch.controller;

 import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.SpringBatch.dto.ResponseMessageDto;
import com.springboot.SpringBatch.exception.ResourceNotFoundException;
import com.springboot.SpringBatch.model.Employee;
import com.springboot.SpringBatch.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	  
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
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
	
	@GetMapping("/api/employee/all")
	public Page<Employee> getAllEmployee(
			@RequestParam(required = false, defaultValue = "0") int page, 
			@RequestParam(required = false, defaultValue = "5000") int size) {
		Pageable pageable =  PageRequest.of(page, size);
		logger.info("Fetching all employees using pageable...");
		if(size==5000)
			logger.warn("Fetching employees without limit ");
		return employeeService.getAllEmployee(pageable);
	}
	
	@GetMapping("/api/employee/all/v2")
	public  List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@DeleteMapping("/api/employee/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id, 
			ResponseMessageDto dto) 
					throws ResourceNotFoundException {
		logger.info("deleting employee by id");
		employeeService.validate(id);
		employeeService.deleteById(id);
		dto.setMsg("Employee Deleted");
		logger.info("Employee deleted with ID: " + id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/api/employee/search")
	public List<Employee> searchByName(@RequestParam String name) {
		return employeeService.searchByName(name);
	}
	
	@GetMapping("/api/employee/search/v2")
	public List<Employee> searchByNameV2(@RequestParam String name) {
		return employeeService.searchByNameV2(name);
	}
}
