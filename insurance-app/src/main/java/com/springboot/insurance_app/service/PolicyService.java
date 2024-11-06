package com.springboot.insurance_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.insurance_app.model.Policy;
import com.springboot.insurance_app.repository.PolicyRepository;

@Service
public class PolicyService {

	@Autowired
	private PolicyRepository policyRepository;
	
	public Policy insert(Policy policy) {
		return policyRepository.save(policy);
		
	}

	public List<Policy> getAllPolicy() {
		 
		return policyRepository.findAll();
	}

}
