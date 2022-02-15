package com.taco.jms;


import com.taco.domain.Order;

public interface OrderMessagingService {
    void sendOrder(Order order);
}
