package com.mymart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Admin 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)  
  private Long adminId;
  private String name;
  private String workMail;
  private String contact;
  private String password;
}
