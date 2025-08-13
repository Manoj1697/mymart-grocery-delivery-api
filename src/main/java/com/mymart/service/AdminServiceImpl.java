package com.mymart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymart.dto.AdminDto;
import com.mymart.entity.Admin;
import com.mymart.exception.DuplicateEntryException;
import com.mymart.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
	AdminRepository adminRepository;
	
	@Override
	public Long addAdminInfo(AdminDto adminDto) 
	{
		 if(adminRepository.existsByWorkMail(adminDto.getWorkMail()))
			 throw new DuplicateEntryException("Work-Mail Already Exist!!");
		 
	    Admin admin = new Admin();
	      admin.setWorkMail(adminDto.getWorkMail());
	      admin.setName(adminDto.getName());
	      admin.setContact(adminDto.getContact());
	      admin.setPassword(adminDto.getPassword());
		
	        Admin newAdmin = adminRepository.save(admin);
	        return newAdmin.getAdminId();
	     
	}

}
