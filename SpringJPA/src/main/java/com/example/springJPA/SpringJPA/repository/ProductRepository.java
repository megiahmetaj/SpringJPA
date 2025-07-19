package com.example.springJPA.SpringJPA.repository;

import com.example.springJPA.SpringJPA.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
