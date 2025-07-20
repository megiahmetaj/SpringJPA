package com.example.springJPA.SpringJPA.controller;

import com.example.springJPA.SpringJPA.model.Category;
import com.example.springJPA.SpringJPA.model.Product;
import com.example.springJPA.SpringJPA.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // get /categories/{id}/products
    @GetMapping("/{id}/products")
    public List<Product> getProductByCategory(@PathVariable Long id){
        return categoryService.getProductByCategory(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category){
        return categoryService.save(category);
    }
}
