package com.designpatterns.factory;

public class RTGS extends Payment{

	@Override
	public void processPayment(String acctNo, double amount, TransactionType type) {
		 System.out.println("IMPS does this");
		
	}
}
