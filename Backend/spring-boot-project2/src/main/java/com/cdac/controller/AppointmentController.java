package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.CustomerRegistrationStatus;
import com.cdac.dto.Status;
import com.cdac.entity.Customer;
import com.cdac.entity.ServiceAppointment;
import com.cdac.exceptions.CustomerServiceException;
import com.cdac.service.AppointmentService;
import com.cdac.service.CustomerService;

import jakarta.transaction.Transactional;

@CrossOrigin
@Transactional
@RestController
public class AppointmentController 
{
	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("/appointment/register")
	public ResponseEntity<ServiceAppointment> register(@RequestBody ServiceAppointment appointment) 
	{
		try {
		      appointmentService.register(appointment);
			//CustomerRegistrationStatus status = new CustomerRegistrationStatus();
//			status.setStatus(true);
//			status.setMessageIfAny("Registration successful!");
//			status.setCustomerId(id);
//			
//			return new ResponseEntity<Status>(status, HttpStatus.OK);
				
		}
		catch(CustomerServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");
			
			//return new ResponseEntity<Status>(status, responseHeaders, HttpStatus.BAD_REQUEST);
		}
		return null;
		
	}
	@GetMapping("/all_appointment")
	public List<ServiceAppointment> fetchById() 
    {
		return appointmentService.fetchById();
		
	}
	
	 @DeleteMapping("appointment/delete/{id}")
	    public Status deleteAppointment(@PathVariable int id)
	    {
		 appointmentService.delete(id);
	       Status s=new Status();
	       s.setStatus(true);
	       s.setMessageIfAny("deleted Successfull");
	       return s;
	     
	    }
	
}
