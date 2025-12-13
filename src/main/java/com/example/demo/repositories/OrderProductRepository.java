package com.example.demo.repositories;

import com.example.demo.models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProduct.OrderProductId> {
}
