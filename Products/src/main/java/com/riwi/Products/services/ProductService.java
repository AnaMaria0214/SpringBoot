package com.riwi.Products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.Products.Entities.Product;
import com.riwi.Products.Repositories.ProductRepository;
import com.riwi.Products.services.service_abstract.IProductServece;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductServece{

    @Autowired
    private final ProductRepository productRepository;



    @Override
    public Product save(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Product> getall() {
    return this.productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Product delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Product update(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Product> search(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
    
}
