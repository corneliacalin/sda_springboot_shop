package com.sda.corneliacalin.webshop.service;

import com.sda.corneliacalin.webshop.model.*;
import com.sda.corneliacalin.webshop.repository.BillRepository;
import com.sda.corneliacalin.webshop.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final BillRepository billRepository;

    public OrderService(OrderRepository orderRepository, BillRepository billRepository) {
        this.orderRepository = orderRepository;
        this.billRepository = billRepository;
    }

    public void save(Customer customer, List<Product> products) {

        Bill bill = new Bill();
        bill.setIssueDate(Timestamp.from(Instant.now()));
        //  bill.setDueDate(Timestamp.from(Instant.now().plus(7, ChronoUnit.DAYS)));
        bill.setDueDate(Timestamp.from(Instant.now().plus(Duration.ofDays(7))));
        bill.setCurrency(products.get(0).getCurrency());

        double total=0;
        for (Product product: products) {
          total=total+ product.getPrice();
        }
        bill.setAmount(total);
        billRepository.save(bill);


        Order order = new Order();
        order.setProducts(products);
        order.setStatus(OrderStatus.NEW);
        order.setCreationDate(Timestamp.from(Instant.now()));
        order.setCustomer(customer);
        orderRepository.save(order);
        order.setBill(bill);
    }
}
