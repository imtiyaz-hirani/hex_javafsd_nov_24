package com.springboot.JWTSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.JWTSecurity.enums.Role;
import com.springboot.JWTSecurity.model.Executive;
import com.springboot.JWTSecurity.model.User;
import com.springboot.JWTSecurity.repository.ExecutiveRepository;
import com.springboot.JWTSecurity.repository.UserRepository;
@Service
public class ExecutiveService {

	@Autowired
	private ExecutiveRepository executiveRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	public Executive addExecutive(Executive executive) {
		/*detach user from given executive */
		User user = executive.getUser();
		user.setRole(Role.EXECUTIVE);
		
		String encPassword = passwordEncoder.encode(user.getPassword());
		 
		user.setPassword(encPassword);
		user = userRepository.save(user); //complete user with role, password and id
		
		executive.setUser(user);
		
		return executiveRepository.save(executive);
	}

}
