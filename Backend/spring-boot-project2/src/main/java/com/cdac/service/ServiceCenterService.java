package com.cdac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Customer;
import com.cdac.entity.Service_Centre;
import com.cdac.entity.Technician;
import com.cdac.exceptions.CustomerServiceException;
import com.cdac.exceptions.TechnicianException;
import com.cdac.repository.ServiceCentreRepository;
import com.cdac.repository.TechnicianRepository;

@Service
public class ServiceCenterService 
{

	@Autowired
	private ServiceCentreRepository serviceCenterRepository;
	public int register(Service_Centre serviceCenter)
	{
		Optional<Service_Centre> serviceCenterCheck=serviceCenterRepository.findByEmail(serviceCenter.getEmail());
		if(serviceCenterCheck.isEmpty())
		{
			Service_Centre saveServiceCenter=serviceCenterRepository.save(serviceCenter);
			return saveServiceCenter.getCentre_id();
		}
		else
		{
			throw new TechnicianException("Service Centre already Registerd");
		}
	}
	
	public List<Service_Centre> fetchById() 
	{
	  List<Service_Centre> serviceCenter=serviceCenterRepository.findAll();
	  return serviceCenter;
	    
	}
	public Service_Centre login(String email, String password)
	{
		Optional<Service_Centre> cerviceCenter = serviceCenterRepository.findByEmailAndPassword(email, password);
		if(cerviceCenter.isPresent())
			return cerviceCenter.get();
		else
			throw new CustomerServiceException("Invalid Email/Password");
	}
}
