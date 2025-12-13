package com.example.demo.services;

import com.example.demo.dtos.OrderDto;
import com.example.demo.mappers.OrderMapper;
import com.example.demo.models.Order;
import com.example.demo.repositories.OrderProductRepository;
import com.example.demo.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderProductRepository orderProductRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
        this.orderMapper = orderMapper;
    }

    public OrderDto createOrder() {
        var order = new Order();
        orderRepository.save(order);

        return orderMapper.fromEntity(order);
    }

    public Optional<OrderDto> getOrderByIdAndUsername(long orderId, String username) {
        var order = this.orderRepository.findByIdAndUsername(orderId, username);

        if (order.isPresent()) {
            return Optional.of(orderMapper.fromEntity(order.orElseThrow()));
        }

        return Optional.empty();
    }
}
