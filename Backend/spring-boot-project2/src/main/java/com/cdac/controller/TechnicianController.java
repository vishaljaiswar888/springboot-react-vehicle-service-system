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


import com.cdac.dto.Status;
import com.cdac.dto.TechnicianRegistrationStatus;
import com.cdac.entity.Customer;
import com.cdac.entity.Technician;
import com.cdac.service.TechnicianService;

import jakarta.transaction.Transactional;

@CrossOrigin("http://localhost:3000")
@Transactional
@RestController
public class TechnicianController 
{
	@Autowired
	private TechnicianService technicianService;
	
	@PostMapping("/technician/register")
	public ResponseEntity<Status> register(@RequestBody Technician technician)
	{
		try
		{
			int id=technicianService.register(technician);
			TechnicianRegistrationStatus status = new TechnicianRegistrationStatus();
			status.setStatus(true);
			status.setMessageIfAny("Technician Registration successful!");
			status.setTechnician_id(id);
			
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
	
	 @GetMapping("/all_technician")
		public List<Technician> fetchById() 
	    {
			return technicianService.fetchById();
			
		}

}
