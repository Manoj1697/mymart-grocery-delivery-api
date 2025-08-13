package com.mymart.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDto 
{
  private Integer categoryId;
  @NotBlank(message="Category cannot be null, empty, or whitespace")
  private String name;
  @NotBlank(message="CategoryDescription cannot be null, empty, or whitespace")
  private String categoryDescription;
  
  private GroceryItemsDto groceryItemsDto;
}
