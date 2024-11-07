package com.springboot.insurance_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.insurance_app.model.Executive;
import com.springboot.insurance_app.repository.ExecutiveRepository;

@Service
public class ExecutiveService {

	@Autowired
	private ExecutiveRepository executiveRepository;
	
	public Executive insert(Executive executive) {
		 
		return executiveRepository.save(executive);
	}

}
