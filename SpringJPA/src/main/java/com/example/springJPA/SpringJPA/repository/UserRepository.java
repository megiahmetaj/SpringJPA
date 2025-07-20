package com.example.springJPA.SpringJPA.repository;

import com.example.springJPA.SpringJPA.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name); // metoda per kerkimin sipas emrit
    Optional<User> findByEmail(String email);
}
