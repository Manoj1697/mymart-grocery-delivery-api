package com.mymart.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class GroceryItemsDto 
{
  private Integer itemId;
  @NotBlank(message="Name cannot be null, empty, or whitespace")
  private String name;
  @NotBlank(message = "Unit cannot be null, empty, or whitespace")
  private String unit;
  @Positive(message="Price cannot be negative")
  private double price;
  @NotBlank(message="Description cannot be null, empty, or whitespace")
  private String description;

  private Integer categoryId;
}
