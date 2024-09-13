package com.example.scmorderservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class InventoryClient {

    private final WebClient webClient;

    public InventoryClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://inventory-service").build();
    }

    public Mono<Boolean> checkAvailability(Long productId, int quantity) {
        return webClient.get()
                .uri("/inventory/check?productId={productId}&quantity={quantity}", productId, quantity)
                .retrieve()
                .bodyToMono(Boolean.class);
    }
}
