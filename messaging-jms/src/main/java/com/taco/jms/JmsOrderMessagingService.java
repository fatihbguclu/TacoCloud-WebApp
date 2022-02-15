package com.taco.jms;

import com.taco.domain.Order;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsOrderMessagingService implements OrderMessagingService{

    private final JmsTemplate jmsTemplate;

    public JmsOrderMessagingService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendOrder(Order order) {
        jmsTemplate.convertAndSend("tacocloud.order.queue", order,
                message -> {
                    message.setStringProperty("X_ORDER_SOURCE","WEB");
                    return message;
        });
    }


}
