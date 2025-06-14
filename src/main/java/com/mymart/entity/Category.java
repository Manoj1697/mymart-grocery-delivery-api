package com.mymart.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Category 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)  
  private long categoryId;
  @Column(unique=true)
  private String name;
  private String categoryDescription;
  
  @OneToMany(mappedBy="category",cascade=CascadeType.ALL)
  private List<GroceryItems> groceryItems;
}
