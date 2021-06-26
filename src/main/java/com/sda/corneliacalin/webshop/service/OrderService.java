package com.sda.corneliacalin.webshop.service;

import com.sda.corneliacalin.webshop.model.*;
import com.sda.corneliacalin.webshop.repository.BillRepository;
import com.sda.corneliacalin.webshop.repository.CustomerRepository;
import com.sda.corneliacalin.webshop.repository.OrderRepository;
import com.sda.corneliacalin.webshop.repository.ProductRepository;
import com.sda.corneliacalin.webshop.service.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final BillRepository billRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, BillRepository billRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.billRepository = billRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public void save(OrderDTO orderDTO) {
        Optional<Customer> customer = customerRepository.findById(orderDTO.getCustomerId());
        if (customer.isPresent()) {
            List<Product> products =new ArrayList<>();
            for (Long productId : orderDTO.getProductIds()){
                Optional<Product> product= productRepository.findById(productId);
                if (product.isPresent()) {
                    products.add(product.get());
                }
                else {
                    throw new IllegalArgumentException("No product found in DB "+ productId);
                }
                save(customer.get(),products);
            }
        } else {
            throw new IllegalArgumentException("No customer was found in DB for the given id" + orderDTO.getCustomerId());

        }


    }

    public void save(Customer customer, List<Product> products) {

        Bill bill = new Bill();
        bill.setIssueDate(Timestamp.from(Instant.now()));
        //  bill.setDueDate(Timestamp.from(Instant.now().plus(7, ChronoUnit.DAYS)));
        bill.setDueDate(Timestamp.from(Instant.now().plus(Duration.ofDays(7))));
        bill.setCurrency(products.get(0).getCurrency());

        double total = 0;
        for (Product product : products) {
            total = total + product.getPrice();
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

    public void updateStatus(Long orderId, OrderStatus status){
        Optional<Order> order =orderRepository.findById(orderId);
        if(order.isPresent()){
            order.get().setStatus(status);
            orderRepository.save(order.get());

        }
        else {
            throw new IllegalArgumentException("order not found");
        }

    }

}
