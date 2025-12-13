package com.example.demo.controllers;

import com.example.demo.dtos.Order.RequestOrderDto;
import com.example.demo.dtos.Order.ResponseOrderDto;
import com.example.demo.models.User;
import com.example.demo.services.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}")
    public ResponseEntity<ResponseOrderDto> getOrderById(@PathVariable long id, HttpSession session) {
        if(session.getAttribute("user") instanceof User user) {
            var order = this.orderService.getOrderByIdAndUsername(id, user.getUsername());

            if (order.isPresent()) {
                return ResponseEntity.ok(order.orElseThrow());
            }
        }

        return ResponseEntity.badRequest().build();
    }
}
