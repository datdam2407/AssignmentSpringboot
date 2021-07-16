package com.datdt.AssignmentSpringboot.test.serviceTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.datdt.AssignmentSpringboot.entity.StatusProduct.RECEIVED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.datdt.AssignmentSpringboot.entity.Order;
import com.datdt.AssignmentSpringboot.entity.StatusOrder;
import com.datdt.AssignmentSpringboot.entity.StatusProduct;
import com.datdt.AssignmentSpringboot.repository.OrderRepository;
import com.datdt.AssignmentSpringboot.repository.StatusRepository;
import com.datdt.AssignmentSpringboot.service.OrderService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.yaml.snakeyaml.events.Event.ID;

@SpringBootTest
public class OrderTestService {
    @Autowired
    private OrderService orderService;
    @MockBean
    private OrderRepository orderRepository;
    private StatusRepository statusRepository;
    @MockBean
    Order Order;
    StatusProduct statusProduct;
    public static final String PRODUCTNAME = "PRODUCTNAME";
    public static final String STATUSNAME = "RECEIVED";
    public static final Long ID = 1L;
    private static final Object StatusOrder = null;
    
    List<Order> list;

    @BeforeEach
    public void setUpOrder() {
        list = new ArrayList<>();
        Order order = new Order(new Date(), 15000000, "dat", "0123456789", "Q12");
        Order order1 = new Order(new Date(), 19000000, "datdam", "0123456789", "Q1");
        Order order2 = new Order(new Date(), 191000000, "datdamday", "0123456789", "Q11");
        list.add(order);
        list.add(order1);
        list.add(order2);
    }

    @Test
    public void getAllTest_returnOrderList() throws Exception {
        when(orderRepository.findAll()).thenReturn(list);
        assertEquals(orderService.getAllOrders(), list);
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    public void whenValidID_thenOrderShouldBeFound() throws Exception {

        Order Order = new Order();
        Optional<Order> optional = Optional.of(Order);
        assertNotNull(optional);
        when(orderRepository.findById(ID)).thenReturn(optional);
        ResponseEntity<Order> Order2 = orderService.getOrderById(ID);
        assertEquals(Order2.getBody().getCustomerName(), Order.getCustomerName());
    }
    @Test
    public void whenValidID_thenDeleteOrderShouldBeFound() throws Exception {
        Order Order = new Order();
        Optional<Order> optional = Optional.of(Order);
        assertNotNull(optional);
        when(orderRepository.findById(ID)).thenReturn(optional);
        Map<String, Boolean> Order2 = orderService.deleteOrder(ID);
        assertEquals(Order2.equals(true), false);
    }
    @Test
    public void updateStatus_ThenReturnOrder() throws Exception {
        Order Order = new Order();
        Optional<Order> optional = Optional.of(Order);
        assertNotNull(optional);
        when(orderRepository.findById(ID)).thenReturn(optional);   
        com.datdt.AssignmentSpringboot.entity.Order Order2 = orderService.updateStatus(ID);
    }
    // @Test
    // public void createOrder_ThenReturnOrder() throws Exception {
    //     when(orderRepository.save(list.get(0))).thenReturn(list.get(0));
    //     assertEquals(orderService.createOrder(list.get(0)), list.get(0));
    // }

}