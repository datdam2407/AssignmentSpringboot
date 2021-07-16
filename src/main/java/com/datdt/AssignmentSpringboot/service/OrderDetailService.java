package com.datdt.AssignmentSpringboot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.datdt.AssignmentSpringboot.entity.Cart;
import com.datdt.AssignmentSpringboot.entity.Order;
import com.datdt.AssignmentSpringboot.entity.OrderDetail;
import com.datdt.AssignmentSpringboot.entity.Product;
import com.datdt.AssignmentSpringboot.entity.StatusOrder;
import com.datdt.AssignmentSpringboot.entity.StatusProduct;
import com.datdt.AssignmentSpringboot.exception.NotFoundException;
import com.datdt.AssignmentSpringboot.repository.OrderDetailRepository;
import com.datdt.AssignmentSpringboot.repository.StatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final StatusRepository statusRepository;

    @Autowired
    public OrderDetailService(OrderDetailRepository orderDetailRepository,StatusRepository statusRepository) {
        this.orderDetailRepository = orderDetailRepository;
        this.statusRepository = statusRepository;

    }
    public List<OrderDetail> getOrderDetails(){
            return this.orderDetailRepository.findAll();    
    }
    //get Details by orderID
    public List<OrderDetail> getOrderDetailByOrderID(Long orderId){
        return (List<OrderDetail>) this.orderDetailRepository.findDetailByOrderID(orderId);   
    }
    // create OrderDetail
    
    public List<OrderDetail> createOrderDetail(Order newOrder, HttpSession session) throws Exception{
        Cart shoppingCart = (Cart) session.getAttribute("shCart");
        List<OrderDetail> listDetail = new ArrayList<>();
        if(shoppingCart == null){
            throw new Exception("Cart Empty!!");
        } else {
            for (Product cartProduct : shoppingCart.getCart().values()) {
                OrderDetail detail = new OrderDetail(cartProduct.getCartQuantity(),
                 newOrder, cartProduct);
                orderDetailRepository.save(detail);
                listDetail.add(detail);
            }
        }
        
        return listDetail;
    }
    public OrderDetail feedBack(long orderDetailId, OrderDetail detail){
        OrderDetail orderDetail = orderDetailRepository.findById(orderDetailId).orElseThrow();
        StatusOrder status =  statusRepository.findByName(StatusProduct.RECEIVED).orElseThrow();
        if(orderDetail.getOrder().getStatus().contains(status)){
            orderDetail.setAmount(orderDetail.getAmount());
            orderDetail.setOrder(orderDetail.getOrder());
            orderDetail.setOrderDetailID(orderDetail.getOrderDetailID());
            orderDetail.setProduct(orderDetail.getProduct());
            orderDetail.setFeedbackContent(detail.getFeedbackContent());
            orderDetail.setRateStar(detail.getRateStar());
            return orderDetailRepository.save(orderDetail);
        }
        return orderDetail;
    }
    
    public Map<String, Boolean> deleteOrderDetailById(Long OrderDetailID){
        OrderDetail orderDetail = orderDetailRepository.findById(OrderDetailID)
                .orElseThrow(() -> new NotFoundException(OrderDetailID));
            this.orderDetailRepository.delete(orderDetail);
            Map<String, Boolean> response = new HashMap<>();
            response.put("DELETED", Boolean.TRUE);
            return response;
    }
}
