package com.mymart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymart.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>
{

}
