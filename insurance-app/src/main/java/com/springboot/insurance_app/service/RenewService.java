package com.springboot.insurance_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.insurance_app.model.Renew;
import com.springboot.insurance_app.repository.RenewRepository;

@Service
public class RenewService {

	@Autowired
	private RenewRepository renewRepository;

	public Renew insert(Renew renew) {
		 
		return renewRepository.save(renew);
	}
}
