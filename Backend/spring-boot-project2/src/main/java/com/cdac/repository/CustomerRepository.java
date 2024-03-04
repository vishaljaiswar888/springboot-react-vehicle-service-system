package com.cdac.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Optional<Customer> findByEmail(String email);

	Optional<Customer> findByEmailAndPassword(String email, String password);

	Customer save(Optional<Customer> existingCustomer);



}
