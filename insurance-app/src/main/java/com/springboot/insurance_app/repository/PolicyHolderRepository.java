package com.springboot.insurance_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.insurance_app.model.Policy;
import com.springboot.insurance_app.model.PolicyHolder;

public interface PolicyHolderRepository extends JpaRepository<PolicyHolder, Integer>{

	@Query("select p from PolicyPolicyHolder pph "
			+ " join pph.policyHolder ph "
			+ " join pph.policy p where ph.id=?1")
	List<Policy> getPolicyDetails(int phid);

}
