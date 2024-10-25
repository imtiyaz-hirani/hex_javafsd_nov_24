package com.designpatterns.factory;

public class UPI extends Payment{

	 @Override
	public void processPayment(String acctNo, double amount, TransactionType type) {
		System.out.println("UPI does this ");
		
	}
}
