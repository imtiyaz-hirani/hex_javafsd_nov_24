package com.hibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "accountholder_account")
public class AccountHolderAccount { //aha

	@Id
	private int id;
	
	@ManyToOne
	private AccountHolder accountHolder; //in Db it will create accountholder_id
	
	@ManyToOne
	private Account account; //account_id

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "AccountHolderAccount [id=" + id + ", accountHolder=" + accountHolder + ", account=" + account + "]";
	}
	
	
}
