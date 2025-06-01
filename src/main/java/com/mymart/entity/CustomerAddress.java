package com.mymart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CustomerAddress 
{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer addressId;
  private Integer houseNumber;
  private String street;
  private String nearbyLandmark;
  private String city;
  private Integer pincode;
  
}
