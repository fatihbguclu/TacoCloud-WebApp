package com.taco.kitchen.kitchen;

import com.taco.kitchen.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KitchenUI {

    public void displayOrder(Order order){
        log.info("Received Order: " + order.toString());
    }

}
