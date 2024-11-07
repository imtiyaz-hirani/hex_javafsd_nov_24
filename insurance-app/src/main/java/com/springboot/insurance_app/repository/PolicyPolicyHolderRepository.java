package com.springboot.insurance_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.insurance_app.model.PolicyPolicyHolder;

public interface PolicyPolicyHolderRepository extends JpaRepository<PolicyPolicyHolder, Integer>{

	@Query(value = "select * from policy_policyholder where policy_id=?1 AND policy_holder_id=?2 AND is_active=?3", nativeQuery = true)
	Optional<PolicyPolicyHolder> verify(int pid, int phid, boolean activeStatus);

}
