package com.cdac.exceptions;

public class TechnicianException extends RuntimeException
{

	public TechnicianException(String message, Throwable cause) 
	{
		super(message,cause);
	}
	public TechnicianException(String message)
	{
		super(message);
	}
}
