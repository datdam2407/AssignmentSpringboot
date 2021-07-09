package com.datdt.AssignmentSpringboot.controller;

import java.util.List;
import java.util.Map;

import com.datdt.AssignmentSpringboot.entity.OrderDetail;
import com.datdt.AssignmentSpringboot.service.OrderDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/api/public")
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @Autowired
    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("/orderdetails")
    public List<OrderDetail> getAllOrderDetail(){
        return this.orderDetailService.getOrderDetails();
    }

    @GetMapping("/orders/orderdetails/{id}")
    public List<OrderDetail> getDetailByOrderID(@PathVariable(value = "id") Long orderID){
        return this.orderDetailService.getOrderDetailByOrderID(orderID);
    }

    @DeleteMapping("/orders/orderdetails/{id}")
    public Map<String, Boolean> deleteOrderDetailById(@PathVariable(value = "id") Long OrderDetailID){
        return this.orderDetailService.deleteOrderDetailById(OrderDetailID);
    }

    @PostMapping("/orders/orderdetails")
    public OrderDetail createOrderDetail(@RequestBody OrderDetail newDetail){
        return this.orderDetailService.createOrderDetail(newDetail);
    }
}
