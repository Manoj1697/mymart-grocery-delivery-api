package com.mymart.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mymart.entity.GroceryItems;

public interface GroceryItemsRepository extends JpaRepository<GroceryItems,Integer>
{
    //public Optional<GroceryItems> findByName(String name);
    
    boolean existsByNameIgnoreCase(String groceryName);
    
    public List<GroceryItems> findByCategory_NameIgnoreCase(String name);
}
