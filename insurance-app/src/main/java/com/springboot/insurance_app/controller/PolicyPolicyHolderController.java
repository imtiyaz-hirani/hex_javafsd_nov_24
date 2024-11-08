package com.springboot.insurance_app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.insurance_app.dto.PolicyResponseDto;
import com.springboot.insurance_app.dto.ResponseMessageDto;
import com.springboot.insurance_app.exception.ResourceNotFoundException;
import com.springboot.insurance_app.model.Policy;
import com.springboot.insurance_app.model.PolicyHolder;
import com.springboot.insurance_app.model.PolicyPolicyHolder;
import com.springboot.insurance_app.service.PolicyHolderService;
import com.springboot.insurance_app.service.PolicyPolicyHolderService;
import com.springboot.insurance_app.service.PolicyService;

@RestController
public class PolicyPolicyHolderController {

	@Autowired
	private PolicyHolderService policyHolderService;
	
	@Autowired
	private PolicyService policyService;
	
	@Autowired
	private PolicyPolicyHolderService policyPolicyHolderService;
	/*
	 * Policy holder is going to purchase the policy via this api 
	 * path: /policyholder/policy/purchase
	 * path-param: policyHolderId, policyId 
	 * method: POST
	 * body: 
	 * return: PolicyPolicyHolder  
	 * */
	
	@PostMapping("/policyholder/policy/purchase/{policyHolderId}/{policyId}")
	public ResponseEntity<?> purchasePolicy(@PathVariable int policyHolderId, 
							   @PathVariable int policyId,
							   @RequestBody PolicyPolicyHolder policyPolicyHolder,
							   ResponseMessageDto dto ) {
		 
		//I am getting the values of dateOfRenewal and premium from request body. 
		
		//i need to validate policyHolderId and fetch PolicyHolder obj 
		PolicyHolder policyHolder = null; 
		try {
			policyHolder =  policyHolderService.validate(policyHolderId);
		} catch (ResourceNotFoundException e) {
			 dto.setMsg(e.getMessage());
			 return ResponseEntity.badRequest().body(dto);
		}
		Policy policy = null;
		//i need to validate policyId and fetch Policy obj 
		try {
			policy =policyService.validate(policyId);
		} catch (ResourceNotFoundException e) {
			dto.setMsg(e.getMessage());
			 return ResponseEntity.badRequest().body(dto);
		}
		
		//attach the above 2 objects to policyHolderPolicy object. 
		policyPolicyHolder.setPolicyHolder(policyHolder);
		policyPolicyHolder.setPolicy(policy);
		
		//set dateOfPurchase to current date in policyHolderPolicy object
		policyPolicyHolder.setDateOfPuchase(LocalDate.now());
		
		//save this obj in the DB and return it 
		policyPolicyHolder = policyPolicyHolderService.insert(policyPolicyHolder);
		return ResponseEntity.ok(policyPolicyHolder);
		
	}
	
	/*
	 * This api will activate or de-activate the policy 
	 * If and when the premium is paid, the policy will get activated. 
	 * */
	@PostMapping("/policy/state/{phpid}")
	public ResponseEntity<?> changePolicyStatus(@RequestParam boolean status, 
									@PathVariable int phpid,
									ResponseMessageDto dto) {
		//validate phpid and fetch object 
		PolicyPolicyHolder policyPolicyHolder =null; 
		
		try {
			policyPolicyHolder = policyPolicyHolderService.validate(phpid);
		} catch (ResourceNotFoundException e) {
			dto.setMsg(e.getMessage());
			 return ResponseEntity.badRequest().body(dto);
		}
		
		policyPolicyHolder.setActive(status);
		
		//save this obj in the DB and return it 
		policyPolicyHolder = policyPolicyHolderService.insert(policyPolicyHolder);
		return ResponseEntity.ok(policyPolicyHolder);
	}
	
	
	@GetMapping("/policy-holder/policy")
	public List<PolicyResponseDto> getAllPolicyHolderWithPolicyDetails() {
		List<PolicyResponseDto> list 
				=  policyPolicyHolderService.getAllPolicyHolderWithPolicyDetails();
		return list;
	}
}
