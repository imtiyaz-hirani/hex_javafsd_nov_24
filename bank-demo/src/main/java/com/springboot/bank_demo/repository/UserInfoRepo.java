package com.springboot.bank_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bank_demo.model.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, Integer> {

}
