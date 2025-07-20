package com.example.springJPA.SpringJPA.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // nje kategori ka shume produkte
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();
    // cascade -> kur fshin/ruan nje kategori veprimi applikohet automatikisht dhe te produktet qe ka kjo kategori
    // orphanRemoval = true nqs hiqet nje produkt nga lista qe mund te kete nje kategori ai produkt do te
    //fshihet dhe nga databaza

}
