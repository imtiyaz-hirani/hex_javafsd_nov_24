package com.springboot.bank_demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.bank_demo.dto.ResponseMsgDto;
import com.springboot.bank_demo.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	private ResponseMsgDto dto; 
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(Exception e) {
		dto.setMsg(e.getMessage());
		return ResponseEntity.badRequest().body(dto);
	}
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<?> handleIOException(IOException e) {
		dto.setMsg(e.getMessage());
		return ResponseEntity.badRequest().body(dto);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGeneralException(Exception e) {
		dto.setMsg(e.getMessage());
		return ResponseEntity.badRequest().body(dto);
	}
}
