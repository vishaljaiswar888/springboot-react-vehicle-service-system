package com.cdac.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cdac.entity.Technician;

public interface TechnicianRepository extends JpaRepository<Technician, Integer>
{

	Optional<Technician> findByEmail(String email);
	Optional<Technician> findByEmailAndPassword(String email, String password);
	Optional save(Optional<Technician> existingTechnician);
}
