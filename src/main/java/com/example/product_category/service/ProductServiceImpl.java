package com.example.product_category.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.product_category.entity.Category;
import com.example.product_category.entity.Product;
import com.example.product_category.exception.ResourceNotFoundException;
import com.example.product_category.repository.CategoryRepository;
import com.example.product_category.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Page<Product> getAllProducts(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@Override
	public Product getProductById(Long id) {
		Optional<Product> optional=productRepository.findById(id);
		Product product;
		if(optional.isPresent())
			return optional.get();
		else
			throw new ResourceNotFoundException("Product not found");
//		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
	}

	@Override
	public Product createProduct(Product product) {
		Category category = categoryRepository.findById(product.getCategory().getId())
				.orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);
        return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Long id, Product productDetails) {
		Product product=getProductById(id);
		product.setName(productDetails.getName());
		product.setPrice(productDetails.getPrice());
		
		Category category=categoryRepository.findById(productDetails.getCategory().getId()).orElseThrow(()-> new ResourceNotFoundException("Category not found"));
	    product.setCategory(category);
	    return productRepository.save(product);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}
