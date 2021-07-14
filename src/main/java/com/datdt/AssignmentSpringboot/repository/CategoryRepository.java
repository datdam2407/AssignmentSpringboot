package com.datdt.AssignmentSpringboot.repository;

import com.datdt.AssignmentSpringboot.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category , Long>{
}
