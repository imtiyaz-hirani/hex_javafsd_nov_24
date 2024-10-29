package com.hibernate.controller;

import java.util.List;
import java.util.Scanner;

import com.hibernate.exception.ResourceNotFoundException;
import com.hibernate.model.Account;
import com.hibernate.model.AccountHolder;
import com.hibernate.model.AccountHolderAccount;
import com.hibernate.model.Executive;
import com.hibernate.service.AccountService;
import com.hibernate.service.AuthService;
import com.hibernate.service.ExecutiveService;
import com.hibernate.utility.FactoryUtility;

import jakarta.persistence.EntityManager;

public class BankController {
	public static void main(String[] args) {
		EntityManager entityManager = FactoryUtility.getInstance().loadPersistence();
		Scanner sc = new Scanner(System.in);	
		
		ExecutiveService executiveService = new ExecutiveService(entityManager);
		AuthService authService = new AuthService(entityManager);
		AccountService accountService = new AccountService(entityManager);
		
		System.out.println("----------BANK LOGIN-------------");
		System.out.println("Enter Username:");
		String username = sc.next();
		System.out.println("Enter password:");
		String password = sc.next();
		
		boolean isAdmin =  authService.checkIfAdmin(username,password);
		
		if(isAdmin == true) {
			while(true) {
				System.out.println("Welcome " + username);
				System.out.println("-----Admin Menu-----");
				System.out.println("1. Onboard Executive");
				System.out.println("2. Fetch all Executives");
				System.out.println("3. Delete Executive");
				System.out.println("0. Exit");
				int input = sc.nextInt();
				if(input == 0) {
					System.out.println("Exiting , thank you!!");
					break; 
				}
				switch(input) {
					case 1:
						Executive executive = executiveService.takeInputAndGenerateId(sc);
						//check username uniqueness 
						boolean isUnique =  authService.checkIfUsernameUnique(executive.getUser().getUsername());
						if(isUnique == true) {
							//save executive and user in DB
							executiveService.saveExecutiveAnduser(executive);
							System.out.println("Executive added in DB");
						}
						else {
							System.out.println("Username already in use...");
						}
						break;
				}		
			}
		}
		 
		else {
			try {
				Executive executive = executiveService.checkLogin(username,password);
				System.out.println("Welcome " + executive.getName());
				while(true) {
					System.out.println("------EXECUTIVE MENU-------");
					System.out.println("1. Create Account for AccountHolder");
					System.out.println("2. Search Account Holder Info with Account by Contact");
					System.out.println("0. Exit");
					int input = sc.nextInt();
					if(input == 0) {
						System.out.println("Exiting , thank you!!");
						break; 
					}
					switch(input) {
					case 1: 
						AccountHolder accountHolder =  accountService.takeAHInputAndGenerateId(sc);
						Account account = accountService.createAccount(sc);
						AccountHolderAccount accountHolderAccount = new AccountHolderAccount();
						accountHolderAccount.setAccountHolder(accountHolder);
						accountHolderAccount.setAccount(account);
						//gen ID
						int ahaId =(int) (Math.random()*1000000000);
						accountHolderAccount.setId(ahaId);
						
						//save 
						accountService.insert(account,accountHolder,accountHolderAccount);
						System.out.println("Account Created......");
						break; 
					case 2:
						System.out.println("Enter contact no. ");
						List<AccountHolderAccount> list= accountService.fetchAccountHolderWithAccountByContact(sc.next());
						list.stream().forEach(System.out :: println);
						
						break;
					default:
						break;
					}
				}
			} catch (ResourceNotFoundException e) {
				 System.out.println(e.getMessage());
				  
			}
			 
			
			
			
		}
		sc.close();
	}
}
