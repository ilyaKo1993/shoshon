package com.example.scmorderservice.service;

import com.example.scmorderservice.model.Order;
import com.example.scmorderservice.repository.OrderRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderService(OrderRepository orderRepository, InventoryClient inventoryClient, KafkaTemplate<String, Order> kafkaTemplate) {
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Mono<Order> createOrder(Long productId, int quantity) {
        Order order = new Order();
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setStatus("PENDING");
        order.setOrderDate(LocalDateTime.now());
        order.setUpdateDate(LocalDateTime.now());

        return inventoryClient.checkAvailability(productId, quantity)
                .flatMap(available -> {
                    if (available) {
                        order.setStatus("CONFIRMED");
                        orderRepository.save(order);
                        kafkaTemplate.send("order-events", order); // Асинхронная отправка события в Kafka
                        return Mono.just(order);
                    } else {
                        return Mono.error(new RuntimeException("Товара нет на складе"));
                    }
                });
    }
}
