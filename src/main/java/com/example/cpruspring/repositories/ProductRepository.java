package com.example.cpruspring.repositories;

import com.example.cpruspring.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
}
