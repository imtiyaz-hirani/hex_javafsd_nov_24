package com.springboot.SpringHttpBasicSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SpringHttpBasicSecurity.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
}
