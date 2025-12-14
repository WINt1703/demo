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
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final PickUpPointRepository pickUpPointRepository;
    private final OrderMapper orderMapper;
    private final OrderProductRepository orderProductRepository;

    public OrderService(OrderRepository orderRepository,
                        OrderMapper orderMapper,
                        PickUpPointRepository pickUpPointRepository,
                        OrderProductRepository orderProductRepository,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.pickUpPointRepository = pickUpPointRepository;
        this.productRepository = productRepository;
        this.orderProductRepository = orderProductRepository;
    }

    @Transactional
    public Optional<ResponseOrderDto> createOrder(RequestOrderDto orderDto, String username) {
        try {
            var pickUp = this.pickUpPointRepository.findById(orderDto.pickUpPointId()).orElseThrow();
            var order = new Order();
            order.setOrderProducts(new HashSet<>());

            this.orderMapper.copyToEntity(order, orderDto, pickUp, username);

            for(ProductIdCount productIdCount: orderDto.productIdCountCollection()) {
                var product = this.productRepository.findById(productIdCount.productId()).orElseThrow();
                var orderProduct = new OrderProduct();

                product.getOrderProducts().add(orderProduct);
                order.getOrderProducts().add(orderProduct);

                orderProduct.setProduct(product);
                orderProduct.setOrder(order);
                orderProduct.plusCount(productIdCount.count());

                this.orderProductRepository.save(orderProduct);
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
