package com.datdt.AssignmentSpringboot.service;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.datdt.AssignmentSpringboot.entity.Account;
import com.datdt.AssignmentSpringboot.entity.Cart;
import com.datdt.AssignmentSpringboot.entity.Order;
import com.datdt.AssignmentSpringboot.entity.OrderDetail;
import com.datdt.AssignmentSpringboot.entity.Product;
import com.datdt.AssignmentSpringboot.entity.StatusOrder;
import com.datdt.AssignmentSpringboot.entity.StatusProduct;
import com.datdt.AssignmentSpringboot.exception.NotFoundException;
import com.datdt.AssignmentSpringboot.repository.OrderRepository;
import com.datdt.AssignmentSpringboot.repository.ProductRepository;
import com.datdt.AssignmentSpringboot.repository.StatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailService orderDetailService;
    private final ProductRepository productRepository;
    private final AccountService accountService;
    private final StatusRepository statusRepository;
    Date currentDate = new Date();

    @Autowired

    // List order
    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();

    }

    public OrderService(OrderRepository orderRepository, OrderDetailService orderDetailService,
            ProductRepository productRepository, AccountService accountService, StatusRepository statusRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailService = orderDetailService;
        this.productRepository = productRepository;
        this.accountService = accountService;
        this.statusRepository = statusRepository;
    }

    // get order by ID
    public ResponseEntity<Order> getOrderById(Long orderID) throws NotFoundException {
        Order order = orderRepository.findById(orderID).orElseThrow(() 
        -> new NotFoundException(orderID));
        return ResponseEntity.ok().body(order);
    }
    //delete order
    public Map<String, Boolean> deleteOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() 
        -> new NotFoundException(orderId));
        List<OrderDetail> detailList = this.orderDetailService.getOrderDetailByOrderID
        (order.getOrderID());
        if (detailList.size() != 0) {
            for (OrderDetail orderDetail : detailList) {
                this.orderDetailService.deleteOrderDetailById(orderDetail.
                getOrderDetailID());
            }
        }
        this.orderRepository.delete(order);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }
    // get order by userID
    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order updateStatus(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() 
        -> new NotFoundException(orderId));
        Set<StatusOrder> status = new HashSet<>();
        StatusOrder statusName = statusRepository.findByName(StatusProduct.RECEIVED)
        .orElseThrow();
        status.add(statusName);
        order.setStatus(status);
        return orderRepository.save(order);
    }
    // Save
    public Order createOrder(HttpSession session) throws Exception {
        Cart shCart = (Cart) session.getAttribute("shCart");
        if (shCart == null) {
            throw new Exception("Cart is Empty!!");
        }
        for (Product cartProduct : shCart.getCart().values()) {
            Optional<Product> valProduct = productRepository.findById(cartProduct.getProductID());
            if (cartProduct.getCartQuantity() > valProduct.get().getProductQuantity()) {
                throw new Exception("Sorry We only have " + valProduct.get().getProductQuantity() + " out of stock!!");
            }}
        String username = (String) session.getAttribute("currentUsername");
        Account currentUser = accountService.findByUsername(username);
        Order newOrder = new Order(new Date(), shCart.getTotalofOrder(), currentUser.getFullname(), currentUser.getPhone(), 
        currentUser.getAddress());
        Set<StatusOrder> status = new HashSet<>();
        StatusOrder statusName = statusRepository.findByName(StatusProduct.WAITING).orElseThrow();
        status.add(statusName);
        newOrder.setStatus(status);
        orderRepository.save(newOrder);
        orderDetailService.createOrderDetail(newOrder, session);
        return newOrder;
    }

}