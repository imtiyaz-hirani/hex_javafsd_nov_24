package com.hibernate.controller;

import java.util.Scanner;

import com.hibernate.model.Executive;
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
		
		String username =  authService.checkIfAdmin(sc);
		
		if(!(username == null)) {
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
			System.out.println("Invalid Credentials.. Exiting");
		}
		sc.close();
	}
}
