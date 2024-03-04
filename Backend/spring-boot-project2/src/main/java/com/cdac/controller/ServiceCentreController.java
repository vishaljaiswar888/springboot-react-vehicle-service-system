package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.LoginDetails;
import com.cdac.dto.LoginStatus;
import com.cdac.dto.Service_CenterRegistrationStatus;
import com.cdac.dto.Status;
import com.cdac.dto.TechnicianRegistrationStatus;
import com.cdac.entity.Customer;
import com.cdac.entity.Service_Centre;
import com.cdac.entity.Technician;
import com.cdac.exceptions.CustomerServiceException;
import com.cdac.service.ServiceCenterService;
import com.cdac.service.TechnicianService;

import jakarta.transaction.Transactional;

@CrossOrigin
@Transactional
@RestController
public class ServiceCentreController 
{
	@Autowired
	private ServiceCenterService serviceCenterService;
	
	@PostMapping("/service_center/register")
	public ResponseEntity<Status> register(@RequestBody Service_Centre serviceCenter)
	{
		try
		{
			int id=serviceCenterService.register(serviceCenter);
			Service_CenterRegistrationStatus status = new Service_CenterRegistrationStatus();
			status.setStatus(true);
			status.setMessageIfAny("Service_Center Registration successful!");
			status.getService_center_id();
			
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
		catch (Exception e) 
		{
			Status status = new Status();
			status.setStatus(false);
			status.setMessageIfAny("Registration unsuccessfull");
			
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");
			
			return new ResponseEntity<Status>(status, responseHeaders, HttpStatus.BAD_REQUEST);
		}
	}
	
	 @GetMapping("/all_serviceCenter")
		public List<Service_Centre> fetchById() 
	    {
			return serviceCenterService.fetchById();
			
		}
		
		 @PostMapping("/serviceCenter/login")
			public Status login(@RequestBody Service_Centre loginCenter)
		    {
				try 
				{
					Service_Centre serviceCenter = serviceCenterService.login(loginCenter.getEmail(), loginCenter.getPassword());
					LoginStatus status = new LoginStatus();
					status.setStatus(true);
					status.setMessageIfAny("Login successful!");
					System.out.println(serviceCenter.getCentre_id());	
					status.setCustomerId(serviceCenter.getCentre_id());
//					status.setName(customer.getName());
					//status.setCustomer(customer);
					return status;
				}
				catch (CustomerServiceException e)
				{
					Status status = new Status();
					status.setStatus(false);
					status.setMessageIfAny("login failed");
					return status;
				}
			}

}
