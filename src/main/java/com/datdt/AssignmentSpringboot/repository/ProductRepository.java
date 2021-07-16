package com.datdt.AssignmentSpringboot.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.datdt.AssignmentSpringboot.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long>{
 
    @Query("FROM Product WHERE category_id = ?1")
    List<Product> findAllProductsByCategoryID(long categoryID);

    @Query("FROM Product WHERE product_id = ?1")
    Product findProductById(long productId);

    @Transactional
    @Modifying
    @Query("UPDATE Product SET product_quantity = ?1 WHERE product_id = ?2")
    int updateQuantity(int newQuantity, long productId);
}

