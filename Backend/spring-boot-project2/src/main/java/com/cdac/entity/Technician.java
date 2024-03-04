package com.cdac.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Technician 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tech_id;
	private String email;
	private String name;
	private String password;
	private int experience;
	private long contact_number;
	private String skills;
	
	
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTech_id() {
		return tech_id;
	}
	public void setTech_id(int tech_id) {
		this.tech_id = tech_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public long getContact_number() {
		return contact_number;
	}
	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}
	
	
	
	
	

}
