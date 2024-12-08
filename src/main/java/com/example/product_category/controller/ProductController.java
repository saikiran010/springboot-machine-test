package com.example.product_category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_category.entity.Product;
import com.example.product_category.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
    @Autowired
	private ProductService productService;
	
    @GetMapping
    public Page<Product> getProducts(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
    	return productService.getAllProducts(PageRequest.of(page, size));
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
    	return productService.createProduct(product);
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
    	return productService.getProductById(id);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,@RequestBody Product productDetails) {
    	return productService.updateProduct(id, productDetails);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
