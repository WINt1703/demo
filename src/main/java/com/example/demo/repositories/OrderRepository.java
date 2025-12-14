package com.example.demo.repositories;

import com.example.demo.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Collection<Order>> findAllByUsername(String username);
}
