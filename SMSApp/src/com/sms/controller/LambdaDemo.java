package com.sms.controller;

public class LambdaDemo {
	public static void main(String[] args) {
		 Inter i = new Inter() { //Anonymous Inner class / Anonymous Overriding 
			@Override
			public void m1() {
				 System.out.println("m1");
			}		 
		 };
		 i.m1();
	}
}

interface Inter{ //functional interface 
	void m1(); //public abstract
	
}
/*
 * If an interface has a single abstract method, then it is called as Functional Interface
 * To override this method of functional interface, we can write lambda exp. 
 */
