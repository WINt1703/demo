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

import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final PickUpPointRepository pickUpPointRepository;
    private final OrderProductRepository orderProductRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository,
                        OrderProductRepository orderProductRepository,
                        OrderMapper orderMapper,
                        PickUpPointRepository pickUpPointRepository,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
        this.orderMapper = orderMapper;
        this.pickUpPointRepository = pickUpPointRepository;
        this.productRepository = productRepository;
    }

    public Optional<ResponseOrderDto> createOrder(RequestOrderDto orderDto) {
        try {
            var pickUp = this.pickUpPointRepository.findById(orderDto.pickUpPointId()).orElseThrow();
            var order = new Order();

            this.orderMapper.copyToEntity(order, orderDto, pickUp);
            order = this.orderRepository.save(order);

            for(ProductIdCount productIdCount: orderDto.productIdCountCollection()) {
                var product = this.productRepository.findById(productIdCount.productId()).orElseThrow();
                var orderProduct = new OrderProduct();
                product.addOrderProduct(orderProduct);
                order.addOrderProduct(orderProduct);
                orderProduct.plusCount(productIdCount.count());

                this.orderProductRepository.save(orderProduct);
            }

    public Optional<OrderDto> getOrderByIdAndUsername(long orderId, String username) {
        var order = this.orderRepository.findByIdAndUsername(orderId, username);

        if (order.isPresent()) {
            return Optional.of(orderMapper.fromEntity(order.orElseThrow()));
        }

        return Optional.empty();
    }
}
