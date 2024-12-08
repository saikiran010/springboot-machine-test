package com.example.product_category.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.product_category.entity.Category;

public interface CategoryService {
	
   public Page<Category> getAllCategories(Pageable pageable);
   
   public Category getCategoryById(Long id);
   
   public Category createCategory(Category category);
   
   public Category updateCategory(Long id, Category category);
   
   public void deleteCategory(Long id);
}
