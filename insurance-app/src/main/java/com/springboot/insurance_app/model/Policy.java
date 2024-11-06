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

@Entity
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	@Column(nullable = false)
	private String title; 
	
	@Column(length = 1000)
	private String description; 
	
	@Enumerated(EnumType.STRING)
	private Policy_Category policyCategory;
	
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

	@Override
	public String toString() {
		return "Policy [id=" + id + ", title=" + title + ", description=" + description + ", policyCategory="
				+ policyCategory + ", policyType=" + policyType + "]";
	}
	
	
}
