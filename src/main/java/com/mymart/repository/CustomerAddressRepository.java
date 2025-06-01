package com.mymart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymart.entity.CustomerAddress;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Integer>
{

}
