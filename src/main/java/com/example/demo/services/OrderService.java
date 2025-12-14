package com.example.demo.services;

import com.example.demo.dtos.Order.ProductIdCount;
import com.example.demo.dtos.Order.RequestOrderDto;
import com.example.demo.dtos.Order.ResponseOrderDto;
import com.example.demo.mappers.OrderMapper;
import com.example.demo.models.Order;
import com.example.demo.models.OrderProduct;
import com.example.demo.repositories.OrderProductRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.PickUpPointRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final PickUpPointRepository pickUpPointRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository,
                        OrderMapper orderMapper,
                        PickUpPointRepository pickUpPointRepository,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.pickUpPointRepository = pickUpPointRepository;
        this.productRepository = productRepository;
    }

    public Optional<ResponseOrderDto> createOrder(RequestOrderDto orderDto, String username) {
        try {
            var pickUp = this.pickUpPointRepository.findById(orderDto.pickUpPointId()).orElseThrow();
            var order = new Order();

            this.orderMapper.copyToEntity(order, orderDto, pickUp, username);

            for(ProductIdCount productIdCount: orderDto.productIdCountCollection()) {
                var product = this.productRepository.findById(productIdCount.productId()).orElseThrow();
                var orderProduct = new OrderProduct();
                product.addOrderProduct(orderProduct);
                order.addOrderProduct(orderProduct);
                orderProduct.plusCount(productIdCount.count());
            }

            return Optional.of(this.orderMapper.fromEntity(this.orderRepository.save(order)));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return Optional.empty();
    }

    public Optional<List<ResponseOrderDto>> getUserOrders(String username) {
        var orders = this.orderRepository.findAllByUsername(username);

        if (orders.isPresent()) {
            return Optional.of(orders.orElseThrow().stream().map(this.orderMapper::fromEntity).toList());
        }

        return Optional.empty();
    }
}
