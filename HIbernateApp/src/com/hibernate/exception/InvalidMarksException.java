package com.hibernate.exception;

public class InvalidMarksException extends Exception{
	 
		private static final long serialVersionUID = 1L;
		
		private String message;

		public InvalidMarksException(String message) {
			super();
			this.message = message;
		}

		public String getMessage() {
			return message;
		} 
		
		

	}
