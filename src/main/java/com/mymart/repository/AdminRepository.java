package com.mymart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymart.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>
{

}
