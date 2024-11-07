package com.springboot.insurance_app.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "renew_info")
public class Renew {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	@ManyToOne
	private PolicyPolicyHolder php; 
	
	private LocalDate previousDateOfPurchase; 
	
	private LocalDate currentDateOfPurchase; 
	
	private double previousPremium; 
	
	private double currentPremium; 
	
	@ManyToOne
	private Executive executive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PolicyPolicyHolder getPhp() {
		return php;
	}

	public void setPhp(PolicyPolicyHolder php) {
		this.php = php;
	}

	public LocalDate getPreviousDateOfPurchase() {
		return previousDateOfPurchase;
	}

	public void setPreviousDateOfPurchase(LocalDate previousDateOfPurchase) {
		this.previousDateOfPurchase = previousDateOfPurchase;
	}

	public LocalDate getCurrentDateOfPurchase() {
		return currentDateOfPurchase;
	}

	public void setCurrentDateOfPurchase(LocalDate currentDateOfPurchase) {
		this.currentDateOfPurchase = currentDateOfPurchase;
	}

	public double getPreviousPremium() {
		return previousPremium;
	}

	public void setPreviousPremium(double previousPremium) {
		this.previousPremium = previousPremium;
	}

	public double getCurrentPremium() {
		return currentPremium;
	}

	public void setCurrentPremium(double currentPremium) {
		this.currentPremium = currentPremium;
	}

	public Executive getExecutive() {
		return executive;
	}

	public void setExecutive(Executive executive) {
		this.executive = executive;
	} 
	
	
	
	
}
