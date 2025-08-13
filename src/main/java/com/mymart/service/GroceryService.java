package com.mymart.service;

import java.util.List;

import com.mymart.dto.CategoryDto;
import com.mymart.dto.GroceryItemsDto;

public interface GroceryService 
{
	public Integer addCategory(CategoryDto categoryDto);

	public String addGroceryItem(Integer categoryId,GroceryItemsDto groceryItemsDto);
	
	public List<GroceryItemsDto> getItemsByCategory(String categoryName);
}
