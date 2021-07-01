package com.datdt.AssignmentSpringboot.repository;

import java.util.List;

import com.datdt.AssignmentSpringboot.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long>{
 
    @Query("FROM Product WHERE category_ID = ?1")
    List<Product> findAllProductsByCategoryID(long categoryID);

}

