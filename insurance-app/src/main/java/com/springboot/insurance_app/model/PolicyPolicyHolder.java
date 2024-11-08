package com.springboot.insurance_app.model;

import java.time.LocalDate;

 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "policy_policyholder")
public class PolicyPolicyHolder { //pph

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Policy policy; //p
	
	@ManyToOne
	private PolicyHolder policyHolder;
	
	private LocalDate dateOfPuchase; 
	
	private LocalDate dateOfRenewal; 
	
	private double premium;
	
	@Column
	private boolean isActive =false;

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

	public LocalDate getDateOfPuchase() {
		return dateOfPuchase;
	}

	public void setDateOfPuchase(LocalDate dateOfPuchase) {
		this.dateOfPuchase = dateOfPuchase;
	}

	public LocalDate getDateOfRenewal() {
		return dateOfRenewal;
	}

	public void setDateOfRenewal(LocalDate dateOfRenewal) {
		this.dateOfRenewal = dateOfRenewal;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	} 
	
	
}
