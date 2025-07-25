package com.mymart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymart.dto.AdminDto;
import com.mymart.service.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	AdminServiceImpl adminServiceImpl;
	
   @PostMapping("/add-info")	
   public String addAdminInfo(@RequestBody AdminDto adminDto)
   {   
	    adminServiceImpl.addAdminInfo(adminDto);
	    return "New Admin added!!";
   }
}
