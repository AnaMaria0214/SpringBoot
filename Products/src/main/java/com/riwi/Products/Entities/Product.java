package com.riwi.Products.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="product")

@Data // contiene todos los getter y setter y los toString 
@AllArgsConstructor // contiene el contructor con todos los atributos
@NoArgsConstructor // contiene el constructor vacio 
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int quiantity;
    private double price;

}
