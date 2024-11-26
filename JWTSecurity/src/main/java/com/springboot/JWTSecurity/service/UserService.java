package com.springboot.JWTSecurity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.JWTSecurity.dto.UserCountStatDto;
import com.springboot.JWTSecurity.enums.Role;
import com.springboot.JWTSecurity.exception.InvalidUsernameException;
import com.springboot.JWTSecurity.model.User;
import com.springboot.JWTSecurity.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Autowired
	private UserCountStatDto userCountStatDto;
	
	public User signUp(User user) throws InvalidUsernameException {
		//check for username duplicacy 
		Optional<User> optional = userRepository.findByUsername(user.getUsername());
		if(optional.isPresent()) {
			throw new InvalidUsernameException("Username already in use");
		}
		
		//encrypt the password 
		String encryptedPass = passEncoder.encode(user.getPassword());
		user.setPassword(encryptedPass);
		
		//set the role
		user.setRole(Role.CUSTOMER);
		
		 
		return userRepository.save(user);
	}

	public UserCountStatDto getUserStats() {
		List<User> list = userRepository.findAll();
		//list.stream().forEach(System.out :: println);

		 Map <Role, List<User>> map = list
				 					.parallelStream()
				 					.collect(Collectors.groupingBy(e->e.getRole()));
		// System.out.println(map);
		 Set<Role> listRoles = map.keySet();
		 List<Integer> listData = new ArrayList<>();
		 for(Role role : map.keySet()) {
			 int num =  map.get(role).size();
			 listData.add(num);
		 }
		 userCountStatDto.setLabels(listRoles);
		 userCountStatDto.setData(listData);
		 return userCountStatDto;
		 
	}

}
