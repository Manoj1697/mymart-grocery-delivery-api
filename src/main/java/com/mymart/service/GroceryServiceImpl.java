package com.mymart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymart.dto.CategoryDto;
import com.mymart.dto.GroceryItemsDto;
import com.mymart.entity.Category;
import com.mymart.entity.GroceryItems;
import com.mymart.repository.CategoryRepository;
import com.mymart.repository.GroceryItemsRepository;

@Service
public class GroceryServiceImpl implements GroceryService
{
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	GroceryItemsRepository groceryItemsRepository;
	
	@Override
	public void addCategory(CategoryDto categoryDto) 
	{
		Category category = new Category();
		    category.setName(categoryDto.getName());
		    category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		    categoryRepository.save(category); 
	}

	@Override
	public void addGroceryItem(GroceryItemsDto groceryItemsDto) 
	{	   
	 Optional<Category> category = categoryRepository.findById(groceryItemsDto.getCategoryId()); 
	        if(category.isPresent())
	        {	        	
		        	GroceryItems groceryItems = new GroceryItems();
		 		    groceryItems.setName(groceryItemsDto.getName());
		 		    groceryItems.setUnit(groceryItemsDto.getUnit());
		 		    groceryItems.setPrice(groceryItemsDto.getPrice());
		 		    groceryItems.setItemDescription(groceryItemsDto.getDescription());
		 		   
			 		  groceryItems.setCategory(category.get());
			 		   
			 		   groceryItemsRepository.save(groceryItems);
	        }
	        else
	        {
	        	throw new RuntimeException("Category not found!!");
	        }
	}

}
