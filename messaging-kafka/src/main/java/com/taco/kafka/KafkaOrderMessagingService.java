package com.taco.kafka;

import com.taco.domain.Order;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaOrderMessagingService implements OrderMessagingService{

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public KafkaOrderMessagingService(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendOrder(Order order) {
        kafkaTemplate.send("tacocloud.orders.topic", order);
    }
}
