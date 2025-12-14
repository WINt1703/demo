package com.example.demo.controllers;

import com.example.demo.dtos.Order.RequestOrderDto;
import com.example.demo.dtos.Order.ResponseOrderDto;
import com.example.demo.models.User;
import com.example.demo.services.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseOrderDto> createOrder(@RequestBody RequestOrderDto requestOrderDto) {
        var order = this.orderService.createOrder(requestOrderDto);

        if (order.isPresent()) {
            return ResponseEntity.ok(order.orElseThrow());
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("my")
    public ResponseEntity<List<ResponseOrderDto>> getUserOrders(HttpSession session) {
        if(session.getAttribute("user") instanceof User user) {

            var orders = this.orderService.getUserOrders(user.getUsername());
            if (orders.isPresent()) {
                return ResponseEntity.ok(orders.orElseThrow());
            }
        }

        return ResponseEntity.internalServerError().build();
    }
}
