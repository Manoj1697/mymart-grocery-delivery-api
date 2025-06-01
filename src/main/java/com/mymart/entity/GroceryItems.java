package com.mymart.entity;

import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class GroceryItems 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)  
  private Integer itemId;
  @Column(unique=true)
  private String name;
  private String unit;
  private double price;
  private String itemDescription;
  
  @ManyToOne 
  @JoinColumn(name="categoryId")
  private Category category;
}
