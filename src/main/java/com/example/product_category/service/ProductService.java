package com.example.product_category.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.product_category.entity.Product;

public interface ProductService {

	public Page<Product> getAllProducts(Pageable pageable);
	
	public Product getProductById(Long id);
	
	public Product createProduct(Product product);
	
	public Product updateProduct(Long id,Product productDetails);
	
	public void deleteProduct(Long id);
}
