package com.springboot.bank_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bank_demo.model.AddressInfo;

public interface AddressInfoRepo extends JpaRepository<AddressInfo, Integer>{

}
