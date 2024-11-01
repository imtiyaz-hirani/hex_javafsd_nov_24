package com.springboot.springapp.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {

	static {
		System.out.println("Repo called....");
	}
}
