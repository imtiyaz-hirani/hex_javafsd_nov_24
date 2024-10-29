package com.hibernate.model;

import java.time.LocalDate;

import com.hibernate.enums.AccountType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
@Entity
public class Account {

	@Id
	private int id; 
	
	@Enumerated(EnumType.STRING)
	private AccountType type;
	
	private double balance;
	
	private LocalDate createdAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", type=" + type + ", balance=" + balance + ", createdAt=" + createdAt + "]";
	}
	
	
}
