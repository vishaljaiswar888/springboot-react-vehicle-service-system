package com.cdac.dto;

public class Status 
{
	private int id;
	private boolean status;
	private String messageIfAny;
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessageIfAny() {
		return messageIfAny;
	}
	public void setMessageIfAny(String messageIfAny) {
		this.messageIfAny = messageIfAny;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
