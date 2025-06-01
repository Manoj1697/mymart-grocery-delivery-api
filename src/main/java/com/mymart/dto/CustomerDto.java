package com.mymart.dto;

import lombok.Data;

@Data
public class CustomerDto 
{  	
  private String email;
  private String name;
  private long mobileNumber;
  
  private CustomerAddressDto customeraddressDto;
}
