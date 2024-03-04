package com.cdac.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Admin;
import com.cdac.exceptions.CustomerServiceException;
import com.cdac.repository.AdminRepository;

@Service
public class AdminService 
{

	@Autowired
	private AdminRepository adminRepository;

	public void add(Admin admin) 
	{
		adminRepository.save(admin);
		
	}

	public Admin login(String email, String password)
	{
		Optional<Admin> admin = adminRepository.findByEmailAndPassword(email, password);
		if(admin.isPresent())
			return admin.get();
		else
			throw new CustomerServiceException("Invalid Email/Password");
	}
	
	
}
