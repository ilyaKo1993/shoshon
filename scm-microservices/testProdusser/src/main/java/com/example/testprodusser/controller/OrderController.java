package com.example.testprodusser.controller;

import com.example.testprodusser.model.Order;
import com.example.testprodusser.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendOrderToKafka(@RequestBody Order order) {
        orderService.sendOrderToKafka(order);
        return ResponseEntity.ok("Order sent to Kafka successfully!");
    }
}
