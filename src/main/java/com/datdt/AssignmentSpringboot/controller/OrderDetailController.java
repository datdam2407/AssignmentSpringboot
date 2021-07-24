package com.datdt.AssignmentSpringboot.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.datdt.AssignmentSpringboot.entity.OrderDetail;
import com.datdt.AssignmentSpringboot.service.OrderDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/orderdetails")
@CrossOrigin(origins = "*", maxAge = 3600)

public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @Autowired
    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("/")
    public List<OrderDetail> getAllOrderDetail(){
        return this.orderDetailService.getOrderDetails();
    }

    @GetMapping("/orderId?{orderId}")
    public List<OrderDetail> getDetailByOrderID(@PathVariable(value = "orderId") Long orderID){
        return this.orderDetailService.getOrderDetailByOrderID(orderID);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteOrderDetailById(@PathVariable(value = "id") Long OrderDetailID){
        return this.orderDetailService.deleteOrderDetailById(OrderDetailID);
    }

    @PutMapping("/{detailsId}")
    public OrderDetail feedBack(@PathVariable(value = "detailsId") long detailId,@Valid @RequestBody OrderDetail  orderDetail){
        return this.orderDetailService.feedBack(detailId, orderDetail);
    }
}
