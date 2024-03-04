package com.cdac.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entity.ServiceAppointment;


public interface AppointmentRepository extends JpaRepository<ServiceAppointment, Integer>
{

	

	
}
