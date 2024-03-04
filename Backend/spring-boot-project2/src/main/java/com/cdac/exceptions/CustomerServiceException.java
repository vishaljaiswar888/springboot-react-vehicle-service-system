package com.cdac.exceptions;

public class CustomerServiceException extends RuntimeException 
{
	public CustomerServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerServiceException(String message) {
		super(message);
	}
}
