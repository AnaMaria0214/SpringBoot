package com.riwi.Products.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.Products.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
        public Product findByname (String name);    
} 
    

