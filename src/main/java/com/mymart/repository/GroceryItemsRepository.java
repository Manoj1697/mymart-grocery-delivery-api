package com.mymart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymart.entity.GroceryItems;

public interface GroceryItemsRepository extends JpaRepository<GroceryItems,Integer>
{
    public Optional<GroceryItems> findByName(String name);
}
