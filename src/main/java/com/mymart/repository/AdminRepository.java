package com.mymart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymart.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>
{
   public Optional<Admin> findByWorkMail(String workMail);
   
   public boolean existsByWorkMail(String workMail);
}
