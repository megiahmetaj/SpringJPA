package com.example.springJPA.SpringJPA.repository;

import com.example.springJPA.SpringJPA.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long UserId);
}
