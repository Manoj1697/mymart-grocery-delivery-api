package com.mymart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymart.dto.CategoryDto;
import com.mymart.dto.GroceryItemsDto;
import com.mymart.entity.Category;
import com.mymart.entity.GroceryItems;
import com.mymart.exception.DuplicateEntryException;
import com.mymart.exception.ResourceNotFoundException;
import com.mymart.repository.CategoryRepository;
import com.mymart.repository.GroceryItemsRepository;

import jakarta.transaction.Transactional;

@Service
public class GroceryServiceImpl implements GroceryService
{
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	GroceryItemsRepository groceryItemsRepository;
	
	@Override
	public Integer addCategory(CategoryDto categoryDto) 
	{
		if(categoryRepository.existsByNameIgnoreCase(categoryDto.getName()))
		   throw new DuplicateEntryException(categoryDto.getName()+" :already exist!!");
		
		  Category category = new Category();
		    category.setName(categoryDto.getName());
		    category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		 Category categoryId = categoryRepository.save(category); 
		  return categoryId.getCategoryId();
	}

	@Override
	@Transactional
	public String addGroceryItem(Integer categoryId,GroceryItemsDto groceryItemsDto) 
	{	   
	   Category category = categoryRepository.findById(categoryId)
			              .orElseThrow(()->new ResourceNotFoundException("Category with this ID : "+categoryId+" not Found!!")); 
	        	
	         if(groceryItemsRepository.existsByNameIgnoreCase(groceryItemsDto.getName()))
	            throw new DuplicateEntryException(groceryItemsDto.getName()+" :already exist!!");
		    
	        GroceryItems groceryItems = new GroceryItems();
		 	  groceryItems.setName(groceryItemsDto.getName());
	    	  groceryItems.setUnit(groceryItemsDto.getUnit());
		      groceryItems.setPrice(groceryItemsDto.getPrice());
     		  groceryItems.setItemDescription(groceryItemsDto.getDescription());		 		   
			 	 
     		  groceryItems.setCategory(category);
			 		   
			     groceryItemsRepository.save(groceryItems);
			     
			     return category.getName();
	        
	}

	@Override
	public List<GroceryItemsDto> getItemsByCategory(String categoryName) 
	{
		List<GroceryItems> items = groceryItemsRepository.findByCategory_NameIgnoreCase(categoryName);
		  
		     if(items.isEmpty())
			  throw new ResourceNotFoundException(categoryName+" not found!!");
	    
		List<GroceryItemsDto> dtoList = new ArrayList<>();

	    for (GroceryItems item : items) {
	        GroceryItemsDto dto = new GroceryItemsDto();
	        dto.setItemId(item.getItemId());
	        dto.setName(item.getName());
	        dto.setUnit(item.getUnit());
	        dto.setPrice(item.getPrice());
	        dto.setDescription(item.getItemDescription());
	           Category category = item.getCategory();
	        dto.setCategoryId(category.getCategoryId());
	        dtoList.add(dto);
	    }

	    return dtoList;
	}

}
