package com.springboot.insurance_app.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.insurance_app.exception.ResourceNotFoundException;
import com.springboot.insurance_app.model.Claim;
import com.springboot.insurance_app.repository.ClaimRepository;

@Service
public class ClaimService {

	@Autowired
	private ClaimRepository claimRepository;
	
	public Claim insert(Claim claim) {
		 
		return claimRepository.save(claim);
	}
 
	public Claim isLodged(int policyId, int policyHolderId, LocalDate dateOfPuchase, LocalDate dateOfRenewal) throws ResourceNotFoundException {
		
		Optional<Claim> optional =  claimRepository.isLodged(policyId,policyHolderId, dateOfPuchase, dateOfRenewal);
		 if(optional.isEmpty()){
			 throw new ResourceNotFoundException("No Claim"); 
		 }
		return optional.get();
		
	}

	
}
