package com.designpatterns.singleton;

public class Demo { //frodo
	public static void main(String[] args) {
		EmailUtility.getInstance().sendMail(); //100X
		EmailUtilityAzure.getInstance().sendMail();
	}

}
//500 : 

/*
 * Step frodo in creating Object 
 * of EmailUtility by making constructor private
 * 
 * 
 * 
 */