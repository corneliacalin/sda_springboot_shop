package com.sda.corneliacalin.webshop.repository;

import com.sda.corneliacalin.webshop.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
