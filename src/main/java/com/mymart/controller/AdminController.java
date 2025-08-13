package com.mymart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymart.dto.AdminDto;
import com.mymart.service.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	AdminService adminService;
	
   @PostMapping("/add-info")	
   public ResponseEntity<String> addAdminInfo(@Valid @RequestBody AdminDto adminDto)
   {   
	    Long newAdmin =adminService.addAdminInfo(adminDto);
	    return new ResponseEntity<String>("Admin created with ID :"+newAdmin,HttpStatus.CREATED);
   }
}
