package com.mymart.dto;

import lombok.Data;

@Data
public class CategoryDto 
{
  private long categoryId;
  private String name;
  private String categoryDescription;
  
  private GroceryItemsDto groceryItemsDto;
}
