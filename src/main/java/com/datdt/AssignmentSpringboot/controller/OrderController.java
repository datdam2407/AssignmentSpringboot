package com.datdt.AssignmentSpringboot.controller;

import java.util.List;

import com.datdt.AssignmentSpringboot.entity.Order;
import com.datdt.AssignmentSpringboot.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/api/public")
@RestController
public class OrderController {
    private final OrderService orderService;
    
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    // get List order
    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return this.orderService.getAllOrders();
    }
    // get list order ID 
    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") Long orderId) {
        return this.orderService.getOrderById(orderId);
    }
    // create order
    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order newOrder){
        return this.orderService.createOrder(newOrder);
    }
}
