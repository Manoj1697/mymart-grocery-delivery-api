package com.mymart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mymart.dto.CustomerDto;
import com.mymart.service.CustomerService;

@RestController
public class CustomerController 
{
	@Autowired
	CustomerService customerService;
	
  @PostMapping("new-customer/add-info")
  public String addNewCustomer(@RequestBody CustomerDto customersDto)
  {
	  customerService.addNewCustomer(customersDto);
	return "Thanks for choosing us!!";  
  }
}
