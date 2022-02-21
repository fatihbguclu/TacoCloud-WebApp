package com.taco.kitchen.kitchen.messaging.jms.listener;

import com.taco.kitchen.Order;
import com.taco.kitchen.kitchen.KitchenUI;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Profile("jms-listener")
@Component
public class OrderListener {
    private final KitchenUI ui;

    public OrderListener(KitchenUI ui) {
        this.ui = ui;
    }

    @JmsListener(destination = "tacocloud.order.queue")
    public void receiveOrder(Order order){
        ui.displayOrder(order);
    }


}
