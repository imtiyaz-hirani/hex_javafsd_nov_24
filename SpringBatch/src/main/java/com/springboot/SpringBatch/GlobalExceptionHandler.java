package com.springboot.SpringBatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.SpringBatch.dto.ResponseMessageDto;
import com.springboot.SpringBatch.exception.ResourceNotFoundException;
import com.springboot.SpringBatch.service.EmployeeService;

@ControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	private ResponseMessageDto dto; 
	
	Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	
	@ExceptionHandler(ResourceNotFoundException.class)
	ResponseEntity<?> handleResourceNotFoundException(Exception e){
		 dto.setMsg(e.getMessage());
		 logger.error("ResourceNotFoundException thrown " + dto.getMsg());
		 return ResponseEntity.badRequest().body(dto);
	}
}
