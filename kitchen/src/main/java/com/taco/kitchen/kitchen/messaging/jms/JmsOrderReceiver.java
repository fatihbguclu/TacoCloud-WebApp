package com.taco.kitchen.kitchen.messaging.jms;

import com.taco.kitchen.Order;
import com.taco.kitchen.kitchen.OrderReceiver;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Profile("jms-template")
@Component("templateOrderReceiver")
public class JmsOrderReceiver implements OrderReceiver {

    private final JmsTemplate jmsTemplate;

    public JmsOrderReceiver(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public Order receiveOrder() {
        return (Order) jmsTemplate.receiveAndConvert("tacocloud.order.queue");
    }
}
