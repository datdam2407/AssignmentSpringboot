package com.datdt.AssignmentSpringboot.repository;


import java.util.Optional;

import com.datdt.AssignmentSpringboot.entity.StatusOrder;
import com.datdt.AssignmentSpringboot.entity.StatusProduct;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends CrudRepository<StatusOrder, Long>{
    Optional<StatusOrder> findByName(StatusProduct statusName);
}
