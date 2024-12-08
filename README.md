# Category-Product Management API  

A Spring Boot application for managing Categories and Products with CRUD operations and server-side pagination.  

## Features  
- Category & Product CRUD  
- One-to-Many relationship (Category -> Products)  
- Paginated results  

## APIs  

### Category  
1. `GET /api/categories?page={page}`  
2. `POST /api/categories`  
3. `GET /api/categories/{id}`  
4. `PUT /api/categories/{id}`  
5. `DELETE /api/categories/{id}`  

### Product  
1. `GET /api/products?page={page}`  
2. `POST /api/products`  
3. `GET /api/products/{id}`  
4. `PUT /api/products/{id}`  
5. `DELETE /api/products/{id}`  

## Setup  
1. Configure DB in `application.properties`.  
2. Run using: `mvn spring-boot:run`.  

## Tools  
- Spring Boot, JPA, MySQL  
