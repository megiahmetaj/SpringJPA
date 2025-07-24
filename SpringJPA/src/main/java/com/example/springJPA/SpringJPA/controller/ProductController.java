package com.example.springJPA.SpringJPA.controller;

import com.example.springJPA.SpringJPA.model.Product;
import com.example.springJPA.SpringJPA.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Post /products -> krijimi dhe ruatja e produktit

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.save(product);
    }

    //Get /products -> merr te gjitha produktet
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/price_range")
    public List<Product> getProductsByPriceRange(
            @RequestParam double min,
            @RequestParam double max) {
        return productService.findByPriceRange(min, max);
    }
}
