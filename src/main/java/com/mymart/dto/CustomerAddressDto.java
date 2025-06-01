package com.mymart.dto;

import lombok.Data;

@Data
public class CustomerAddressDto 
{
  private Integer addressId;
  private Integer houseNumber;
  private String street;
  private String nearbyLandmark;
  private String city;
  private Integer pincode; 
}
