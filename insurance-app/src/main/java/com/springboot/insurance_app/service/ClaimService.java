package com.springboot.insurance_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.insurance_app.model.Claim;
import com.springboot.insurance_app.repository.ClaimRepository;

@Service
public class ClaimService {

	@Autowired
	private ClaimRepository claimRepository;
	
	public Claim insert(Claim claim) {
		 
		return claimRepository.save(claim);
	}

	
}
