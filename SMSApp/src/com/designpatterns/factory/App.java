package com.designpatterns.factory;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----CHOOSE PAYMENT METHOD------");
		System.out.println("1. UPI");
		System.out.println("2. NEFT");
		System.out.println("3. RTGS");
		int input = sc.nextInt();
		switch(input) {
		case 1: 
			Payment paymentUpi  = PaymentFactory.getInstance(PaymentType.UPI);
			paymentUpi.processPayment("AC4445655", 10000, TransactionType.DEBIT);			
			break;
		case 2:
			Payment paymentNeft  = PaymentFactory.getInstance(PaymentType.NEFT);
			paymentNeft.processPayment("AC4445655", 10000, TransactionType.DEBIT);	
			break;
		case 3: 
			Payment paymentRtgs  = PaymentFactory.getInstance(PaymentType.RTGS);
			paymentRtgs.processPayment("AC4445655", 10000, TransactionType.DEBIT);
			break; 
		}
		
		sc.close();
	}

}
/*
 * Controller stays clean and free of responsibility 
 * 
 * 							Factory 
 * 
 * 
 * 								Payment
 * 
 * NEFT		RTGS		UPI			IMPS		NetBanking		CreditCard
 * 
 * 																Visa	RuPay 	MasterCard
 * 
 * 															  PIN	NoN-PIN
 
 *				Controller 
 *				----------
 *				Rs. 340 : 1 2 3 4 5 6 
 *							2 
 *
 *				6 sub class Objects 
 *							
 *				A obj = new A(); //100X 
 *				obj=null;	
 *	stack
 *	A obj: 100X / null 
 *
 *  heap
 *  100X: new A()
 *  				
 *	System.gc() --> 
 *
 */