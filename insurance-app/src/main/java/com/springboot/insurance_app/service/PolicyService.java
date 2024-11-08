package com.springboot.insurance_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.insurance_app.enums.Policy_Category;
import com.springboot.insurance_app.exception.ResourceNotFoundException;
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

	public void delete(int id) {
		policyRepository.deleteById(id);
		
	}

	public Policy validate(int id) throws ResourceNotFoundException {
		Optional<Policy> optional = policyRepository.findById(id);
		if(optional.isEmpty())
			throw new ResourceNotFoundException("policy id invalid");
		
		Policy policy = optional.get();
		return policy; 
		
	}

	public List <Policy> insertInBatch(List<Policy> list) {
		return policyRepository.saveAll(list);
		
	}

	public List<Policy> getPoliciesByCategory(Policy_Category pcategory) {
		 
		//return policyRepository.getPoliciesByCategoryNativeSql(pcategory.toString());
		//return policyRepository.getPoliciesByCategoryJPQL(pcategory);
		return policyRepository.findByPolicyCategory(pcategory);
	}

}
