package com.springboot.insurance_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.insurance_app.enums.Policy_Category;
import com.springboot.insurance_app.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Integer>{

	@Query(value = "select * from policy where policy_category = ?1", nativeQuery = true)
	List<Policy> getPoliciesByCategoryNativeSql(String pcategory);

	@Query("select p from Policy p where p.policyCategory=?1")
	List<Policy> getPoliciesByCategoryJPQL(Policy_Category pcategory);

	List<Policy> findByPolicyCategory(Policy_Category pcategory);
	 
}

/*
 * T save(T)  
 * List<T> findAll()  
 * void deleteById(id)
 * Optional<Product> findById(id)
 * 
 */