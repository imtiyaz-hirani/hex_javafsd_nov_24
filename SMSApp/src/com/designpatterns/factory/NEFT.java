package com.designpatterns.factory;

public class NEFT extends Payment{

	@Override
	public void processPayment(String acctNo, double amount, TransactionType type) {
		System.out.println("NEFT does this ");
		
	}
}
