package com.springboot.insurance_app.model;

import java.time.LocalDate;

import com.springboot.insurance_app.enums.ClaimStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	private Policy policy;
	
	@ManyToOne
	private PolicyHolder policyHolder;
	
	@ManyToOne
	private Executive executive;
	
	private LocalDate claimDate; 
	
	private double amount; 
	
	@Enumerated(EnumType.STRING)
	private ClaimStatus claimStatus;
	
	private LocalDate claimStatusDate;
	
	@Column(length = 1000)
	private String remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public PolicyHolder getPolicyHolder() {
		return policyHolder;
	}

	public void setPolicyHolder(PolicyHolder policyHolder) {
		this.policyHolder = policyHolder;
	}

	public Executive getExecutive() {
		return executive;
	}

	public void setExecutive(Executive executive) {
		this.executive = executive;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public ClaimStatus getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(ClaimStatus claimStatus) {
		this.claimStatus = claimStatus;
	}

	public LocalDate getClaimStatusDate() {
		return claimStatusDate;
	}

	public void setClaimStatusDate(LocalDate claimStatusDate) {
		this.claimStatusDate = claimStatusDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	} 
	
	
}
