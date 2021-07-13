package com.datdt.AssignmentSpringboot.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.datdt.AssignmentSpringboot.entity.Category;
import com.datdt.AssignmentSpringboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.web.bind.annotation.ResponseStatus;
import com.datdt.AssignmentSpringboot.repository.CategoryRepository;
@RequestMapping("/categories")
@RestController
public class CategoryController{
    private final CategoryService categoryService;

    @Autowired
    private final CategoryRepository repo;

    @Autowired
    public CategoryController(CategoryService categoryService, CategoryRepository repo) {
        this.categoryService = categoryService;
        this.repo = repo;
    }
    //get all categories
    // @PreAuthorize("hasAnyRole('CUSTOMER','MANAGER')")
    @GetMapping("/")
    public List<Category> getAllCategories(){
        return repo.findAll();  
        
    }
    //get categories by ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getProductById(@PathVariable(value = "id") Long categoryID){
        return categoryService.getProductById(categoryID);
    }
    //Create Category
    @PostMapping("/")
    public Category createCategory(@Valid @RequestBody Category newCategory){
        return categoryService.createCategory(newCategory);

    }
    // @PostMapping("/")
    // public ResponseEntity<Category> createCategory(@Valid @RequestBody Category newCategory){
       
    //     return new ResponseEntity<Category>(newCategory, HttpStatus.CREATED);
    // }

    //Update Category
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") Long categoryID,@Valid @RequestBody Category categoryDetail){     
        return categoryService.updateCategory(categoryID, categoryDetail);
    }
    //Delete Category
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteCategory(@PathVariable(value = "id") Long categoryID){
        return categoryService.deleteCategory(categoryID);
        
    }
    
}
