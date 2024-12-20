package com.springboot.insurance_app.model;

import com.springboot.insurance_app.enums.PolicyType;
import com.springboot.insurance_app.enums.Policy_Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Policy {  //Policy M:1  PolicyHolder

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; //findById(id)
	
	@Column(nullable = false)
	private String title; //findByTitle(title)
	
	@Column(length = 1000)
	private String description; //findByDescription(description)
	 
	@Enumerated(EnumType.STRING)
	private Policy_Category policyCategory; //findByPolicyCategory(category)
	
	@Enumerated(EnumType.STRING)
	private PolicyType policyType;
 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Policy_Category getPolicyCategory() {
		return policyCategory;
	}

	public void setPolicyCategory(Policy_Category policyCategory) {
		this.policyCategory = policyCategory;
	}

	public PolicyType getPolicyType() {
		return policyType;
	}

	public void setPolicyType(PolicyType policyType) {
		this.policyType = policyType;
	}

	 

	 
	
	
}
