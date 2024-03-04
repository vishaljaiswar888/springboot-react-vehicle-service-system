package com.cdac.entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Service_Centre 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int centre_id;
	private String centre_name;
	private String email;
	private String password;
	private String street;
	private String city;
	private String contact_number;
	private String PaymentOption;
	

	private String openingTime;
	private String closingTime;
	

	public String getPaymentOption() {
		return PaymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		PaymentOption = paymentOption;
	}

	public int getCentre_id() {
		return centre_id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCentre_id(int centre_id) {
		this.centre_id = centre_id;
	}
	public String getCentre_name() {
		return centre_name;
	}
	public void setCentre_name(String centre_name) {
		this.centre_name = centre_name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public String getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}

	public String getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
	}

	

}
