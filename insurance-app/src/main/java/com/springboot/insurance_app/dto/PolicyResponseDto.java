package com.springboot.insurance_app.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class PolicyResponseDto {

	private int policy_holder_id;
	private String policy_holder_name;
	private String pan;
	private LocalDate date_of_purchase;
	private LocalDate date_of_renewal;
	private double premium_paid;
	private String policy_category;
	private String policy_type;

	public int getPolicy_holder_id() {
		return policy_holder_id;
	}

	public void setPolicy_holder_id(int policy_holder_id) {
		this.policy_holder_id = policy_holder_id;
	}

	public String getPolicy_holder_name() {
		return policy_holder_name;
	}

	public void setPolicy_holder_name(String policy_holder_name) {
		this.policy_holder_name = policy_holder_name;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public LocalDate getDate_of_purchase() {
		return date_of_purchase;
	}

	public void setDate_of_purchase(LocalDate date_of_purchase) {
		this.date_of_purchase = date_of_purchase;
	}

	public LocalDate getDate_of_renewal() {
		return date_of_renewal;
	}

	public void setDate_of_renewal(LocalDate date_of_renewal) {
		this.date_of_renewal = date_of_renewal;
	}

	public double getPremium_paid() {
		return premium_paid;
	}

	public void setPremium_paid(double premium_paid) {
		this.premium_paid = premium_paid;
	}

	public String getPolicy_category() {
		return policy_category;
	}

	public void setPolicy_category(String policy_category) {
		this.policy_category = policy_category;
	}

	public String getPolicy_type() {
		return policy_type;
	}

	public void setPolicy_type(String policy_type) {
		this.policy_type = policy_type;
	}

}
