package com.mymart.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Customer 
{  
  @Id
  private String email;
  private String name;
  @Column(name="contact",unique=true)
  private long mobileNumber;
  
  @OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="addressId")
  private CustomerAddress customeraddress;
}
