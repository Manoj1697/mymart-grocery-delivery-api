package com.mymart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mymart.dto.CategoryDto;
import com.mymart.dto.GroceryItemsDto;
import com.mymart.service.GroceryService;

@RestController
public class GroceryController 
{
  @Autowired
  GroceryService groceryService;
  
  @PostMapping("/category/add-info")
  public String addCategory(@RequestBody CategoryDto categoryDto)
  {
	  groceryService.addCategory(categoryDto);
	  
	  return "New Category "+categoryDto.getName()+" Added!!";
  }
  
  @PostMapping("grocery-items/add-info")
 public GroceryItemsDto addGroceryItem(@RequestBody GroceryItemsDto groceryItemsDto)
 {
	 groceryService.addGroceryItem(groceryItemsDto); 
	 
	 return groceryItemsDto;
 }
 
 
}
