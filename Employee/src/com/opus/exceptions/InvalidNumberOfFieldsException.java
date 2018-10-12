package com.opus.exceptions;

public class InvalidNumberOfFieldsException extends Exception{

	private String message;
	
	public InvalidNumberOfFieldsException() {
	}
	
	public InvalidNumberOfFieldsException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "InvalidNumberOfFieldsException [message=" + message + "]";
	}
	
	
}
