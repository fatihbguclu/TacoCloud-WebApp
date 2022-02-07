package com.taco.data;



import com.taco.domain.Order;
import com.taco.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, String> {

    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);

}
