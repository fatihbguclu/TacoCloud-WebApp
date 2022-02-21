package com.taco.kitchen.kitchen.messaging.rabbitmq.listener;

import com.taco.kitchen.Order;
import com.taco.kitchen.kitchen.KitchenUI;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("rabbitmq-listener")
@Component
public class OrderListener {

    private KitchenUI ui;

    public OrderListener(KitchenUI ui) {
        this.ui = ui;
    }

    @RabbitListener(queues = "tacocloud.order.queue")
    public void receiveOrder(Order order){
        ui.displayOrder(order);
    }
}
