package com.taco.api;

import com.taco.data.OrderRepository;
import com.taco.domain.Order;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/orders", produces = "application/json")
@CrossOrigin(origins = "*")
public class OrderApiController {

    private final OrderRepository orderRepository;

    public OrderApiController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping(produces = "application/json")
    public Iterable<Order> allOrders(){
        return orderRepository.findAll();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Order postOrder(@RequestBody Order order){
        return orderRepository.save(order);
    }

    @PutMapping(path = "/{orderId}", consumes = "application/json")
    public Order putOrder(@RequestBody Order order, @PathVariable Long orderId){
        Optional<Order> existedOrder = orderRepository.findById(orderId);

        existedOrder.ifPresent(orderRepository::save);

        return null;
    }

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public Order patchOrder(@PathVariable Long orderId, @RequestBody Order patchOrder){

        Optional<Order> optionalOrder = orderRepository.findById(orderId);

        if (optionalOrder.isPresent()){
            Order order = optionalOrder.get();

            if (patchOrder.getDeliveryName() != null)
                order.setDeliveryName(patchOrder.getDeliveryName());

            if (patchOrder.getDeliveryStreet() != null)
                order.setDeliveryStreet(patchOrder.getDeliveryStreet());

            if (patchOrder.getDeliveryCity() != null)
                order.setDeliveryCity(patchOrder.getDeliveryCity());

            if (patchOrder.getDeliveryState() != null)
                order.setDeliveryState(patchOrder.getDeliveryState());

            if (patchOrder.getDeliveryZip() != null)
                order.setDeliveryZip(patchOrder.getDeliveryZip());

            if (patchOrder.getCcNumber() != null)
                order.setCcNumber(patchOrder.getCcNumber());

            if (patchOrder.getCcCVV() != null)
                order.setCcCVV(patchOrder.getCcCVV());

            if (patchOrder.getCcExpiration() != null)
                order.setCcCVV(patchOrder.getCcExpiration());

            return orderRepository.save(order);
        }

        return null;
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long orderId){
        try{
            orderRepository.deleteById(orderId);
        }catch (EmptyResultDataAccessException e){ }
    }

}
