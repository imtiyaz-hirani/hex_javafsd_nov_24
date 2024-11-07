package com.springboot.insurance_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.insurance_app.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer>{

}
