package com.datdt.AssignmentSpringboot.repository;
import java.util.List;

import com.datdt.AssignmentSpringboot.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order , Long>{
    @Query("FROM Order WHERE user_id = ?1")
    List<Order> findByUserId(Long userId);
}
