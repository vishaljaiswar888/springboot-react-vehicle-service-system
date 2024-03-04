package com.cdac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Customer;
import com.cdac.entity.Technician;
import com.cdac.exceptions.TechnicianException;
import com.cdac.repository.TechnicianRepository;

@Service
public class TechnicianService 
{

	@Autowired
	private TechnicianRepository technicianRepository;
	public int register(Technician technician)
	{
		Optional<Technician> technicianCheck=technicianRepository.findByEmail(technician.getEmail());
		if(technicianCheck.isEmpty())
		{
			Technician saveTechnician=technicianRepository.save(technician);
			return saveTechnician.getTech_id();
		}
		else
		{
			throw new TechnicianException("Technician already Registerd");
		}
	}
	
	public List<Technician> fetchById() 
	{
	  List<Technician> technician=technicianRepository.findAll();
	  return technician;
	    
	}
}
