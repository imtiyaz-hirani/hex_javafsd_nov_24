package com.springboot.JWTSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.JWTSecurity.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String username);

}
