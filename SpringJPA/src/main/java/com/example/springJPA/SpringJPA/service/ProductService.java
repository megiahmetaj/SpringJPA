package com.example.springJPA.SpringJPA.service;

import com.example.springJPA.SpringJPA.model.Product;
import com.example.springJPA.SpringJPA.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product save(Product product){
       return productRepository.save(product);
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
