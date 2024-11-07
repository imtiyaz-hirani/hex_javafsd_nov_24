package com.springboot.insurance_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.insurance_app.exception.ResourceNotFoundException;
import com.springboot.insurance_app.model.PolicyHolder;
import com.springboot.insurance_app.repository.PolicyHolderRepository;

@Service
public class PolicyHolderService {

	@Autowired
	private PolicyHolderRepository policyHolderRepository;

	public PolicyHolder insert(PolicyHolder policyholder) {

		return policyHolderRepository.save(policyholder);
	}

	public List<PolicyHolder> getAll() {

		return policyHolderRepository.findAll();
	}

	public PolicyHolder validate(int id) throws ResourceNotFoundException {

		Optional<PolicyHolder> optional = policyHolderRepository.findById(id);
		if (optional.isEmpty())
			throw new ResourceNotFoundException("policyholder id invalid");

		PolicyHolder policyholder = optional.get();
		return policyholder;

	}

	public void delete(int id) {
		policyHolderRepository.deleteById(id);

	}

	public List<PolicyHolder> insertInBatch(List<PolicyHolder> list) {
		return policyHolderRepository.saveAll(list);
	}
}
