package com.springboot.insurance_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.insurance_app.model.PolicyHolder;

public interface PolicyHolderRepository extends JpaRepository<PolicyHolder, Integer>{

}
