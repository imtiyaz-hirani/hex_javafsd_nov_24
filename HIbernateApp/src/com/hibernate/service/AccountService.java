package com.hibernate.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.hibernate.enums.AccountType;
import com.hibernate.enums.RoleType;
import com.hibernate.model.Account;
import com.hibernate.model.AccountHolder;
import com.hibernate.model.AccountHolderAccount;
import com.hibernate.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AccountService {
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	
	public AccountService(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.entityTransaction = entityManager.getTransaction();
	}

	public AccountHolder takeAHInputAndGenerateId(Scanner sc) {
		AccountHolder accountHolder = new AccountHolder();
		System.out.println("Enter name");
		sc.nextLine();
		accountHolder.setName(sc.nextLine());
		System.out.println("Enter Age");
		accountHolder.setAge(sc.nextInt());
		System.out.println("Enter contact");
		accountHolder.setContact(sc.next());
		//gen ID
		int accountHolderId =(int) (Math.random()*1000000000);
		accountHolder.setId(accountHolderId);
		
		System.out.println("----Set up credentials for executive----");
		User user = new User();
		System.out.println("Enter username");
		user.setUsername(sc.next());
		System.out.println("Enter temp password");
		user.setPassword(sc.next());
		//set Role
		user.setRole(RoleType.ACCOUNT_HOLDER);
		user.setPasswordReset(false);
		//get ID
		int userId =(int) (Math.random()*1000000000);
		user.setId(userId);
		 
		accountHolder.setUser(user);
		
		return accountHolder;
	}

	public Account createAccount(Scanner sc) {
		System.out.println("Select Account Type"); 
		Account account = new Account();
		//gen ID
		int accountId =(int) (Math.random()*1000000000);
		account.setId(accountId);
		
		int i=1; 
		for(AccountType type :  AccountType.values() ) {
			System.out.println(i++ + "." + type);
		}
		int input = sc.nextInt();
		switch(input) {
		case 1: 
			account.setType(AccountType.SAVINGS);
			break; 
		 
		case 2: 
			account.setType(AccountType.CURRENT);
			break; 
		case 3: 
			account.setType(AccountType.DMAT);
			break; 
		
	}
		System.out.println("Enter Initial balance:");
		account.setBalance(sc.nextDouble());
		account.setCreatedAt(LocalDate.now());
		
		return account;
	}

	public void insert(Account account, AccountHolder accountHolder, AccountHolderAccount accountHolderAccount) {
		 entityTransaction.begin();
		 entityManager.persist(accountHolder.getUser());
		 entityManager.persist(accountHolder);
		 entityManager.persist(account);
		 entityManager.persist(accountHolderAccount);
 		 entityTransaction.commit();
		
	}
}
