package com.datdt.AssignmentSpringboot.controller;

import java.util.List;
import java.util.Map;

import com.datdt.AssignmentSpringboot.entity.Category;
import com.datdt.AssignmentSpringboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController{
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    //get all categories
    @GetMapping("/categories")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategories();  
    }
    //get categories by ID
    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryByID(@PathVariable(value = "id") Long categoryID){
        return categoryService.getProductById(categoryID);
    }
    //Create Category
    @GetMapping("/categories")
    public Category createCategory(@RequestBody Category newCategory){
        return categoryService.createCategory(newCategory);
    }
    //Update Category
    public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") Long categoryID, @RequestBody Category categoryDetail){     
        return categoryService.updateCategory(categoryID,categoryDetail);
    }
    //Delete Category
    @DeleteMapping("/categories/{id}")
    public Map<String, Boolean> deleteCategory(@PathVariable(value = "id") Long categoryID){
        return categoryService.deleteCategory(categoryID);
    }
}
