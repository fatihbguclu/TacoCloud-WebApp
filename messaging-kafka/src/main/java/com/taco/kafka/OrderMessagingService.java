package com.taco.kafka;

import com.taco.domain.Order;

public interface OrderMessagingService {
    void sendOrder(Order order);
}
