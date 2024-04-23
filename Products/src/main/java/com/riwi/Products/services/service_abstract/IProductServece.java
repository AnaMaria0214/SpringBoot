package com.riwi.Products.services.service_abstract;

import java.util.List;

import com.riwi.Products.Entities.Product;


public interface IProductServece {
    public Product save(Product product);
    public List<Product> getall();
    public Product findById (Long id);
    public Product delete(Long id);
    public Product update(Long id);
    public List<Product> search(String name);
    
} 
