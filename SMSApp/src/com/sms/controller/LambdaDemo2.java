package com.sms.controller;

import java.util.Scanner;

public class LambdaDemo2 {
	public static void main(String[] args) {
		//ravi
		Scanner sc = new Scanner(System.in);
		 System.out.println("Please enter country: ");
		 String country = sc.next();
		 
		 new MyClass().getContinent(() ->{
				return country;
			});
		 sc.close();
	}
	
}
//functional interface 
interface Person { //Neha
	String country();
	//String city();
}


class MyClass{ //rahul 
	
	void getContinent(Person p) {
		switch(p.country().toLowerCase()) {
			case "india":
				System.out.println( p.country() + " is in Asia");
				break; 
			case "italy":
				System.out.println(p.country() + "is in Europe");
				break; 
			default:
				System.out.println(p.country() + "is in unknown continent");
				break;
		}
		 
	}
	
	
}