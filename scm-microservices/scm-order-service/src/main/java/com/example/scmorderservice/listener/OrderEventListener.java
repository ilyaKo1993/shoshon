package com.example.scmorderservice.listener;

import com.example.scmorderservice.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {

    @KafkaListener(topics = "order-events", groupId = "order-group")
    public void handleOrderEvent(Order order) {
        // Логика обработки заказа после отправки в Kafka
        System.out.println("Получено событие о заказе: " + order);
        // Дальнейшая логика, например, уведомление клиента или обновление статуса заказа
        System.out.println("---------------------------------------------------------");
        System.out.println("---------------------------------------------------------");
        System.out.println("" + order);
        System.out.println("---------------------------------------------------------");
        System.out.println("---------------------------------------------------------");
    }
}
