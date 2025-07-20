package com.example.springJPA.SpringJPA.service;

import com.example.springJPA.SpringJPA.model.Category;
import com.example.springJPA.SpringJPA.model.Product;
import com.example.springJPA.SpringJPA.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getProductByCategory(Long categoryId){
        return categoryRepository.findById(categoryId)
                .map(Category::getProducts)
                .orElseThrow(() -> new RuntimeException("Nuk ekziston kjo kategori"));
    // menyre e shkurter per te thirru nje metode mbi nje objekt

    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }
}
