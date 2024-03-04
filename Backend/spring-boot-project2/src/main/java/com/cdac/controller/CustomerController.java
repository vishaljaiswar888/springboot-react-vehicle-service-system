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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.LoginDetails;
import com.cdac.dto.LoginStatus;
import com.cdac.dto.CustomerRegistrationStatus;
import com.cdac.dto.Status;
import com.cdac.entity.Customer;

import com.cdac.exceptions.CustomerServiceException;
import com.cdac.service.CustomerService;

import jakarta.transaction.Transactional;

@CrossOrigin
@Transactional
@RestController
public class CustomerController 
{

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer/register")
	public ResponseEntity<Status> register(@RequestBody Customer customer) 
	{
		try {
			int id = customerService.register(customer);
			CustomerRegistrationStatus status = new CustomerRegistrationStatus();
			status.setStatus(true);
			status.setMessageIfAny("Registration successful!");
			status.setCustomerId(id);
			
			return new ResponseEntity<Status>(status, HttpStatus.OK);
				
		}
		catch(CustomerServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("MyResponseHeader", "MyValue");
			
			return new ResponseEntity<Status>(status, responseHeaders, HttpStatus.BAD_REQUEST);
		}
		
	
		
	}
	
    @GetMapping("/all_customer")
	public List<Customer> fetchById() 
    {
		return customerService.fetchById();
		
	}
    
    
   @PostMapping("/customer/update")
	public Status update(@RequestBody Customer customer) {
		try {
			customerService.update(customer);
			
			Status status = new Status();
			status.setStatus(true);
			status.setMessageIfAny("Customer updated!");
			return status;
		}
		catch(CustomerServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			return status;
		}
	}
	
    
    @PostMapping("/customer/login")
	public Status login(@RequestBody LoginDetails loginDetails)
    {
		try 
		{
			Customer customer = customerService.login(loginDetails.getEmail(), loginDetails.getPassword());
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
			status.setMessageIfAny("login failed");
			return status;
		}
	}
    
    @DeleteMapping("customer/delete/{id}")
    public Status deleteCustomer(@PathVariable int id)
    {
       customerService.delete(id);
       Status s=new Status();
       s.setStatus(true);
       s.setMessageIfAny("deleted Successfull");
       return s;
     
    }
    
    @GetMapping("/customer/fetch/{id}")
	public Customer fetchById(@PathVariable int id) {
		return customerService.fetchById(id);
		//how will we write try catch this time?
	}
	
}
