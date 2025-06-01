package com.mymart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymart.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,String>
{
    Optional<Customer> findByEmail(String email);
}
