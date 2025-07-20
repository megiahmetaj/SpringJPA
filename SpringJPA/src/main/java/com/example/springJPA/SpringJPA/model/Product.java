package com.example.springJPA.SpringJPA.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    // shume produkte lidhen me nje kategori
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
