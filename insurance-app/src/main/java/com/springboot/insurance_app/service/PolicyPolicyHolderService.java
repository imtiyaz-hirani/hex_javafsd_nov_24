package com.springboot.insurance_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.insurance_app.exception.ResourceNotFoundException;
import com.springboot.insurance_app.model.Policy;
import com.springboot.insurance_app.model.PolicyHolder;
import com.springboot.insurance_app.model.PolicyPolicyHolder;
import com.springboot.insurance_app.repository.PolicyPolicyHolderRepository;

@Service
public class PolicyPolicyHolderService {

	@Autowired
	private PolicyPolicyHolderRepository policyPolicyHolderRepository;
	
	public PolicyPolicyHolder insert(PolicyPolicyHolder policyPolicyHolder) {
		 
		return policyPolicyHolderRepository.save(policyPolicyHolder);
	}

	public PolicyPolicyHolder validate(int phpid) throws ResourceNotFoundException {
		Optional<PolicyPolicyHolder> optional 
				=  policyPolicyHolderRepository.findById(phpid);
		
		if(optional.isEmpty())
			throw new ResourceNotFoundException("ID given is Invalid, pls provide main contract ID");
		
		return optional.get();
	}

	public PolicyPolicyHolder verify(Policy policy, PolicyHolder policyHolder) throws ResourceNotFoundException {
		Optional<PolicyPolicyHolder> optional = policyPolicyHolderRepository.verify(policy.getId(),policyHolder.getId(),true);
		
		if(optional.isEmpty())
			throw new ResourceNotFoundException("Policy does not exist, claim cannot be registered..");
		
		return optional.get();
	}

}