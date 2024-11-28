package com.springboot.bank_demo.model;

import java.time.LocalDate;

import com.springboot.bank_demo.enums.AccountType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Account { //Account is dependent on customer -- a
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String accountNum; //Account senderAccount =  findByAccountNum(accountNum)
	@Enumerated(EnumType.STRING)
	private AccountType accountType;//List<Account> listAccounts = findByAccountType(accountType)
	private LocalDate dateOfCreation;//List<Account> listAccounts =  findByDateOfCreation(dateOfCreation)
	private double balance; //List<Account> listAccounts = findByBalance(balance)
	private double transferLimit;
	@ManyToOne
	private Customer customer; //findByCustomerName

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public LocalDate getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(LocalDate dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getTransferLimit() {
		return transferLimit;
	}

	public void setTransferLimit(double transferLimit) {
		this.transferLimit = transferLimit;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
