package com.cdac.controller;

import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.LoginDetails;
import com.cdac.dto.LoginStatus;
import com.cdac.dto.Status;
import com.cdac.entity.Admin;
import com.cdac.entity.Customer;
import com.cdac.exceptions.CustomerServiceException;
import com.cdac.service.AdminService;

@RestController
@CrossOrigin
public class AdminController 
{

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admin_add")
	public Status add(@RequestBody Admin admin)
	{
		adminService.add(admin);
		Status s=new Status();
		s.setStatus(true);
		s.setMessageIfAny("admin inserted successfuly");
		return s;
	}
	
	
	 
    @PostMapping("/admin/login")
	public Status login(@RequestBody LoginDetails loginDetails)
    {
		try 
		{
			Admin customer = adminService.login(loginDetails.getEmail(), loginDetails.getPassword());
			LoginStatus status = new LoginStatus();
			status.setStatus(true);
			status.setMessageIfAny("Login successful!");
			status.setCustomerId(customer.getId());
			status.setName(customer.getName());
			//status.setCustomer(customer);
			return status;
		}
		catch (CustomerServiceException e)
		{
			Status status = new Status();
			status.setStatus(false);
			status.setMessageIfAny("Login Failed");
			return status;
		}
	}
}
