package com.datdt.AssignmentSpringboot.service;

import java.util.List;

import com.datdt.AssignmentSpringboot.entity.Order;
import com.datdt.AssignmentSpringboot.exception.OrderException;
import com.datdt.AssignmentSpringboot.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService{
    private final OrderRepository orderRepository;
    

    @Autowired
    public OrderService(com.datdt.AssignmentSpringboot.repository.OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    //List order
    public List<Order> getAllOrders(){
        return this.orderRepository.findAll();

    }
    // get order by ID
    public ResponseEntity<Order> getOrderById(Long orderID) 
    throws OrderException{
            Order order = orderRepository.findById(orderID)
                                .orElseThrow(() -> new OrderException(orderID));
                return ResponseEntity.ok().body(order);
    }
    //Save
    public Order createOrder(Order newOrder){
                return this.orderRepository.save(newOrder);  
    }
   
}