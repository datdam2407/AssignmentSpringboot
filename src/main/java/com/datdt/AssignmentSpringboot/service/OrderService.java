package com.datdt.AssignmentSpringboot.service;

import java.util.Date;
import java.util.List;

import com.datdt.AssignmentSpringboot.entity.Order;
import com.datdt.AssignmentSpringboot.exception.NotFoundException;
import com.datdt.AssignmentSpringboot.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService{
    private final OrderRepository orderRepository;
    Date currentDate = new Date();


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
    throws NotFoundException{
            Order order = orderRepository.findById(orderID)
                                .orElseThrow(() -> new NotFoundException(orderID));
                return ResponseEntity.ok().body(order);
    }
    //Save
    public Order createOrder(Order newOrder){
        newOrder.setCreateDate(currentDate);
        return this.orderRepository.save(newOrder);  
    }
   
}