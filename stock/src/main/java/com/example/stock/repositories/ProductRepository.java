package com.example.stock.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.stock.entities.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
