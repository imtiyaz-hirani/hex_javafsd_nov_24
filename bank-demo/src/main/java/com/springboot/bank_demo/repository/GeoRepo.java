package com.springboot.bank_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bank_demo.model.Geo;

public interface GeoRepo extends JpaRepository<Geo, Integer>{

}
