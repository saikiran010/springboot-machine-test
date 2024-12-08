package com.example.product_category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.product_category.entity.Category;
import com.example.product_category.exception.ResourceNotFoundException;
import com.example.product_category.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Page<Category> getAllCategories(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public Category getCategoryById(Long id) {
		return categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category not found"));
	}

	@Override
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Long id, Category category) {
		Category existing=getCategoryById(id);
		existing.setName(category.getName());
	    return categoryRepository.save(existing);
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}

}
