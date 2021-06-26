package com.sda.corneliacalin.webshop.controller;


import com.sda.corneliacalin.webshop.model.Order;
import com.sda.corneliacalin.webshop.model.OrderStatus;
import com.sda.corneliacalin.webshop.service.OrderService;
import com.sda.corneliacalin.webshop.service.dto.OrderDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public String addOrder(@RequestBody OrderDTO orderDTO) {
        orderService.save(orderDTO);
        return "Order created";

    }
    @PostMapping("/orders/{id}")

    public String changeStatus(@PathVariable(value="id") Long orderId, @RequestBody String status ){
        orderService.updateStatus(orderId, OrderStatus.valueOf((status)));
        return "Status changed";

    }
}
