package com.green.car.wash.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.green.car.wash.order.model.OrderDetails;
@Repository
public interface OrderRepo extends MongoRepository<OrderDetails, String> {

}
