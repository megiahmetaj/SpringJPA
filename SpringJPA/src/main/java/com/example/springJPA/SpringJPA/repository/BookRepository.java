package com.example.springJPA.SpringJPA.repository;

import com.example.springJPA.SpringJPA.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findFirstByOrderByYearPublishedDesc();

    List<Book> findByYearPublishedGreaterThan(int year);

    List<Book> findByAuthor(String author);
}
