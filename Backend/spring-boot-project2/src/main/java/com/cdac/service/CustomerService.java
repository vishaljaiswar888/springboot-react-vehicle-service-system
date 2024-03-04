package com.cdac.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Customer;
import com.cdac.exceptions.CustomerServiceException;
import com.cdac.repository.CustomerRepository;

@Service
public class CustomerService
{
	@Autowired
	private CustomerRepository customerRepository;

	
	public int register(Customer customer) 
	{//suppose we need to check if this customer has already registered before
		Optional<Customer> customerCheck = customerRepository.findByEmail(customer.getEmail());
		if(customerCheck.isEmpty()) {
			Customer savedCustomer = customerRepository.save(customer);
			return savedCustomer.getId();
		}
		else
			throw new CustomerServiceException("Customer already registered!");
	}

	public List<Customer> fetchById() 
	{
	  List<Customer> customer=customerRepository.findAll();
	  return customer;
	    
	}
	

	public Customer login(String email, String password)
	{
		Optional<Customer> customer = customerRepository.findByEmailAndPassword(email, password);
		if(customer.isPresent())
			return customer.get();
		else
			throw new CustomerServiceException("Invalid Email/Password");
	}

	public Customer update(Customer customer)
	{
	 	
        return customerRepository.save(customer);
	 	
	 		
		
	}

	public void delete(int id) 
	{
		if(!customerRepository.existsById(id))
		{
			throw new RuntimeException("id not found");
		}
		else
		{
		  customerRepository.deleteById(id);
		}
	}

	public Customer fetchById(int id)
	{
		Optional<Customer> customer = customerRepository.findById(id);
		if(customer.isPresent())
			return customer.get();
		else
			throw new CustomerServiceException("Customer with id " + id + " does not exist!");
	}

	
	
	
	
}
