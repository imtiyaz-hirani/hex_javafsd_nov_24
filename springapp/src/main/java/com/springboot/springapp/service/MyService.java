package com.springboot.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.springapp.repository.MyRepository;

@Service
public class MyService {

	static {
		System.out.println("Service called....");
	}
	
	@Autowired
	private MyRepository myRepository;
}
