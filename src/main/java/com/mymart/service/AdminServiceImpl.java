package com.mymart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymart.dto.AdminDto;
import com.mymart.entity.Admin;
import com.mymart.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
	AdminRepository adminRepository;
	
	@Override
	public void addAdminInfo(AdminDto adminDto) 
	{
	   Admin admin = new Admin();
	    admin.setWorkMail(adminDto.getWorkMail());
	    admin.setName(adminDto.getName());
	    admin.setContact(adminDto.getContact());
	    admin.setPassword(adminDto.getPassword());
		
	     adminRepository.save(admin);
	     
	}

}
