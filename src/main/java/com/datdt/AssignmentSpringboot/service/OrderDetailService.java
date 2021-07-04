package com.datdt.AssignmentSpringboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.datdt.AssignmentSpringboot.entity.OrderDetail;
import com.datdt.AssignmentSpringboot.exception.OrderDetailException;
import com.datdt.AssignmentSpringboot.repository.OrderDetailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }
    public List<OrderDetail> getOrderDetails(){
            return this.orderDetailRepository.findAll();    
    }
    //get Details by orderID
    public List<OrderDetail> getOrderDetailByOrderID(Long orderId){
        return (List<OrderDetail>) this.orderDetailRepository.findDetailByOrderID(orderId);   
    }
    // create OrderDetail
    
    public OrderDetail createOrderDetail(OrderDetail newDetail){
        return this.orderDetailRepository.save(newDetail);
    }
    
    public Map<String, Boolean> deleteOrderDetailById(Long OrderDetailID){
        OrderDetail orderDetail = orderDetailRepository.findById(OrderDetailID)
                .orElseThrow(() -> new OrderDetailException(OrderDetailID));
            this.orderDetailRepository.delete(orderDetail);
            Map<String, Boolean> response = new HashMap<>();
            response.put("DELETED", Boolean.TRUE);
            return response;
    }
}
