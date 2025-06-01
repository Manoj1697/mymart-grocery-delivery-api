package com.mymart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymart.dto.CustomerAddressDto;
import com.mymart.dto.CustomerDto;
import com.mymart.entity.Customer;
import com.mymart.entity.CustomerAddress;
import com.mymart.repository.CustomerAddressRepository;
import com.mymart.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService
{
  @Autowired
  CustomerRepository customerRepository;
  @Autowired
  CustomerAddressRepository customerAddressRepository;
	
	@Override
	@Transactional
	public void addNewCustomer(CustomerDto customerDto) 
	{
	  Optional<Customer> optional = customerRepository.findByEmail(customerDto.getEmail());
		                   	
		if(optional.isEmpty())
		{
	  	Customer customer = new Customer();
	  	   customer.setEmail(customerDto.getEmail());
	  	   customer.setName(customerDto.getName());
	  	   customer.setMobileNumber(customerDto.getMobileNumber());
	  	   
	  	  CustomerAddressDto customerAddressDto = customerDto.getCustomeraddressDto();
	  	    CustomerAddress customerAddress = new CustomerAddress();
	  	      customerAddress.setHouseNumber(customerAddressDto.getHouseNumber());
	  	      customerAddress.setStreet(customerAddressDto.getStreet());
	  	      customerAddress.setNearbyLandmark(customerAddressDto.getNearbyLandmark());
	  	      customerAddress.setCity(customerAddressDto.getCity());
	  	      customerAddress.setPincode(customerAddressDto.getPincode());
	  	      
	  	    customer.setCustomeraddress(customerAddress);

	  	  customerRepository.save(customer);
		}
		else
		{
			throw new RuntimeException(customerDto.getEmail()+" with mentioned Address already exist");
		}
	  	      
	}

   
}
