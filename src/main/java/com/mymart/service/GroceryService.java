package com.mymart.service;

import com.mymart.dto.CategoryDto;
import com.mymart.dto.GroceryItemsDto;

public interface GroceryService 
{

	public void addCategory(CategoryDto categoryDto);

	public void addGroceryItem(GroceryItemsDto groceryItemsDto);

}
