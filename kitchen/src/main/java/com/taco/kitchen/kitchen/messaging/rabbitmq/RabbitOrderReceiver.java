package com.taco.kitchen.kitchen.messaging.rabbitmq;

import com.taco.kitchen.Order;
import com.taco.kitchen.kitchen.OrderReceiver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("rabbitmq-template")
@Component("templateOrderReceiver")
public class RabbitOrderReceiver implements OrderReceiver {

    private final RabbitTemplate rabbitTemplate;

    public RabbitOrderReceiver(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public Order receiveOrder() {
        return (Order) rabbitTemplate.receiveAndConvert("tacocloud.order.queue");
    }
}
