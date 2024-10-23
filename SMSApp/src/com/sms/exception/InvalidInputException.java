package com.sms.exception;

public class InvalidInputException extends Exception{

	private static final long serialVersionUID = -1758914556059277278L;
	
	private String message;
	//constructor
	public InvalidInputException(String message) {
		super();
		this.message = message;
	}
	//getter
	public String getMessage() {
		return message;
	} 
	
}
/*
 * When service will set the message it will use constructor
 * When controller will fetch the message to display, it will use getter method  
*/
