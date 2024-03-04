package com.cdac.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entity.Service_Centre;
import com.cdac.entity.Technician;

public interface ServiceCentreRepository extends JpaRepository<Service_Centre, Integer>
{

	Optional<Service_Centre> findByEmail(String email);
	Optional<Service_Centre> findByEmailAndPassword(String email, String password);
	Optional save(Optional<Service_Centre> existingServiceCenter);
}
