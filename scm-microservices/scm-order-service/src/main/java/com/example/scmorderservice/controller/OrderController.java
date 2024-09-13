package com.example.scmorderservice.controller;

import com.example.scmorderservice.model.Order;
import com.example.scmorderservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Mono<ResponseEntity<Order>> createOrder(@RequestParam Long productId, @RequestParam int quantity) {
        return orderService.createOrder(productId, quantity)
                .map(order -> ResponseEntity.ok(order))
                .onErrorResume(e -> Mono.just(ResponseEntity.badRequest().build()));
    }
}
