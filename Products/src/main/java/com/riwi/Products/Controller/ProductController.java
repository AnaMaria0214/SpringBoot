package com.riwi.Products.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.Products.Entities.Product;
import com.riwi.Products.services.service_abstract.IProductServece;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/vi/products")
@AllArgsConstructor
public class ProductController {
     @Autowired
    private final IProductServece productServece;

    @GetMapping
    public ResponseEntity<List<Product>> getall(){
        return ResponseEntity.ok(this.productServece.getall());
    }
   
}
