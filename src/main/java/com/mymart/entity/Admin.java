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
  private long adminId;
  private String name;
  private String workMail;
  private long contact;
  private String password;
}
