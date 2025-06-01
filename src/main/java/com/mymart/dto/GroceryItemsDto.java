package com.mymart.dto;

import lombok.Data;

@Data
public class GroceryItemsDto 
{
  private Integer itemId;
  private String name;
  private String unit;
  private double price;
  private String description;

  private Integer categoryId;
}
