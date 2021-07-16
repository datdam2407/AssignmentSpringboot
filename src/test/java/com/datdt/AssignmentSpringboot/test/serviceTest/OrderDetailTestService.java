package com.datdt.AssignmentSpringboot.test.serviceTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.datdt.AssignmentSpringboot.entity.OrderDetail;
import com.datdt.AssignmentSpringboot.repository.OrderDetailRepository;
import com.datdt.AssignmentSpringboot.service.OrderDetailService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class OrderDetailTestService {
    @Autowired
    private OrderDetailService orderDetailService;
    @MockBean
    private OrderDetailRepository orderDetailRepository;
    @MockBean
    OrderDetail OrderDetail;
    public static final String PRODUCTNAME = "PRODUCTNAME";
    public static final Long ID = 1L;

    List<OrderDetail> list;

    @BeforeEach
    public void setUpOrderDetail() {
        list = new ArrayList<>();
        OrderDetail orderDetail1 = new OrderDetail(1L, "good", 3);
        OrderDetail orderDetail2 = new OrderDetail(1L, "nice ", 4);
        list.add(orderDetail1);
        list.add(orderDetail2);
    }

    @Test
    public void getAllTest_returnOrderDetailList() throws Exception {
        when(orderDetailRepository.findAll()).thenReturn(list);
        assertEquals(orderDetailService.getOrderDetails(), list);
        verify(orderDetailRepository, times(1)).findAll();
    }

    @Test
    public void whenValidID_thenOrderDetailShouldBeFound() throws Exception {

        OrderDetail OrderDetail = new OrderDetail();
        Optional<OrderDetail> optional = Optional.of(OrderDetail);
        assertNotNull(optional);
        when(orderDetailRepository.findById(ID)).thenReturn(optional);
        List<OrderDetail> OrderDetail2 = orderDetailService.getOrderDetailByOrderID(ID);
        assertEquals(orderDetailService.getOrderDetails(),OrderDetail2 );
    }

    // @Test
    // public void createOrderDetail_ThenReturnOrderDetail() throws Exception {
    //     when(orderDetailRepository.save(list.get(0))).thenReturn(list.get(0));
    //     assertEquals(orderDetailService.createOrderDetail(list.get(0)), list.get(0));
    // }


    @Test
    public void whenValidID_thenDeleteOrderDetailShouldBeFound() throws Exception {

        OrderDetail OrderDetail = new OrderDetail();
        Optional<OrderDetail> optional = Optional.of(OrderDetail);
        assertNotNull(optional);
        when(orderDetailRepository.findById(ID)).thenReturn(optional);
        Map<String, Boolean> OrderDetail2 = orderDetailService.deleteOrderDetailById(ID);
        assertEquals(OrderDetail2.equals(true), false);
    }

}
