package com.datdt.AssignmentSpringboot.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
// import javax.validation.Valid;

import com.datdt.AssignmentSpringboot.entity.Cart;
import com.datdt.AssignmentSpringboot.entity.Order;
import com.datdt.AssignmentSpringboot.service.OrderService;
import com.datdt.AssignmentSpringboot.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/orders")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

public class OrderController {
    private final OrderService orderService;
    
    private final ProductService productService;

    @Autowired
        public OrderController(OrderService orderService, 
        ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    // get List order

    @GetMapping("/")
    public List<Order> getAllOrders(){
        return this.orderService.getAllOrders();
    }
    // get list order ID 
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") Long orderId) {
        return this.orderService.getOrderById(orderId);
    }
    // detele order
    @DeleteMapping("/{orderId}")
    public Map<String, Boolean> deleteOrder(@PathVariable(name = "orderId") Long orderId){
        return this.orderService.deleteOrder(orderId);
    }
    //create order with order detail
    @PostMapping("/checkout")
    public Order createOrder(HttpSession session) throws Exception{
        return this.orderService.createOrder(session);
    }
    //confirm - quantity  database
    @PostMapping("/confirm")
    public Cart updateProduct(HttpSession session) throws Exception{
        return this.productService.updateQuantity(session);
    }

    @PostMapping("/receive")
    public Order updateStatus(@RequestParam("orderId") long id){
        return this.orderService.updateStatus(id);
    }
}
