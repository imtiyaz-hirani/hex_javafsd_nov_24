package com.designpatterns.factory;

public class PaymentFactory {

	public static Payment getInstance(PaymentType type) {
		if(type.equals(PaymentType.UPI))  
			return new UPI(); 
		 
		if(type.equals(PaymentType.NEFT))  
			return new NEFT(); 
		 
		if(type.equals(PaymentType.RTGS))  
			return new RTGS(); 
		 
		return null;
	}

	 

}
