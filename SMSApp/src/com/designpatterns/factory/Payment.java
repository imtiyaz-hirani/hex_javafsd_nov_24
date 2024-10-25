package com.designpatterns.factory;

public abstract class Payment {

	public abstract void processPayment(String acctNo, double amount, TransactionType type);
}
