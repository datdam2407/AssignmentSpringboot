package com.datdt.AssignmentSpringboot.repository;


import java.util.List;

import com.datdt.AssignmentSpringboot.entity.OrderDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail , Long>{
        @Query("FROM OrderDetail WHERE order_id = ?1")
    List<OrderDetail>findDetailByOrderID(long orderID);
}

