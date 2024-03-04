package com.cdac.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Customer;
import com.cdac.entity.ServiceAppointment;
import com.cdac.exceptions.CustomerServiceException;
import com.cdac.repository.AppointmentRepository;



@Service
public class AppointmentService 
{
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public int register(ServiceAppointment appointment) 
	{
		
		ServiceAppointment saveAppointment = appointmentRepository.save(appointment);
			return saveAppointment.getAppointment_id();
		
	}

	public List<ServiceAppointment> fetchById() 
	{
	  List<ServiceAppointment>allAppointment=appointmentRepository.findAll();
	  return allAppointment;
	    
	}
	public ServiceAppointment fetchById(int id)
	{
		Optional<ServiceAppointment> serviceApp = appointmentRepository.findById(id);
		if(serviceApp.isPresent())
			return serviceApp.get();
		else
			throw new CustomerServiceException("Appointment with id " + id + " does not exist!");
	}
	
	public void delete(int id) 
	{
		if(!appointmentRepository.existsById(id))
		{
			throw new RuntimeException("id not found");
		}
		else
		{
			appointmentRepository.deleteById(id);
		}
	}

	
}
