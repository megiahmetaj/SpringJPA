package com.example.springJPA.SpringJPA.repository;

import com.example.springJPA.SpringJPA.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
