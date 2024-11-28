package com.springboot.bank_demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Account senderAccount; 
	@ManyToOne
	private Account beneficiaryAccount; 
	
	private double amount; 
	
	private LocalDate dateOfTransfer; 
	
	private String modeOfTransfer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getSenderAccount() {
		return senderAccount;
	}

	public void setSenderAccount(Account senderAccount) {
		this.senderAccount = senderAccount;
	}

	public Account getBeneficiaryAccount() {
		return beneficiaryAccount;
	}

	public void setBeneficiaryAccount(Account beneficiaryAccount) {
		this.beneficiaryAccount = beneficiaryAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDateOfTransfer() {
		return dateOfTransfer;
	}

	public void setDateOfTransfer(LocalDate dateOfTransfer) {
		this.dateOfTransfer = dateOfTransfer;
	}

	public String getModeOfTransfer() {
		return modeOfTransfer;
	}

	public void setModeOfTransfer(String modeOfTransfer) {
		this.modeOfTransfer = modeOfTransfer;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", senderAccount=" + senderAccount + ", beneficiaryAccount="
				+ beneficiaryAccount + ", amount=" + amount + ", dateOfTransfer=" + dateOfTransfer + ", modeOfTransfer="
				+ modeOfTransfer + "]";
	} 
	
	
	
 }
