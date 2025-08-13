package com.mymart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mymart.dto.CategoryDto;
import com.mymart.dto.GroceryItemsDto;
import com.mymart.service.GroceryService;

import jakarta.validation.Valid;

@RestController
public class GroceryController 
{
  @Autowired
  GroceryService groceryService;
  
  @PostMapping("/add-category")
  public ResponseEntity<String> addCategory(@Valid @RequestBody CategoryDto categoryDto)
  {
	  Integer categoryId = groceryService.addCategory(categoryDto);
	  
	 return ResponseEntity.status(HttpStatus.CREATED).body("Category created with ID : "+categoryId);
  }
  
  @PostMapping("add-grocery-items/{categoryId}")
  public ResponseEntity<String> addGroceryItem(@PathVariable Integer categoryId,@Valid @RequestBody GroceryItemsDto groceryItemsDto)
  {
	 String categoryName = groceryService.addGroceryItem(categoryId,groceryItemsDto); 
	 
	 return ResponseEntity.status(HttpStatus.CREATED).body("Item added to :"+categoryName);
  }
  
 
   @GetMapping("category/{categoryName}")
   public List<GroceryItemsDto> getItemsByCategory(@PathVariable String categoryName)
   {
	   return groceryService.getItemsByCategory(categoryName); 
   }
  
 
}
