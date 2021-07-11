package com.datdt.AssignmentSpringboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.datdt.AssignmentSpringboot.entity.Category;
import com.datdt.AssignmentSpringboot.entity.Product;
import com.datdt.AssignmentSpringboot.exception.NotFoundException;
import com.datdt.AssignmentSpringboot.repository.CategoryRepository;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
// @SpringbootTest
public class CategoryService{
    @Mock
    private final CategoryRepository categoryRepository;
    @InjectMocks
    private final ProductService productService;

    @Autowired
    public CategoryService(com.datdt.AssignmentSpringboot.repository.CategoryRepository categoryRepository,
            com.datdt.AssignmentSpringboot.service.ProductService productService) {
        this.categoryRepository = categoryRepository;
        this.productService = productService;
    }
    // @Test
    // get all categories
    public List<Category> getAllCategories(){
        return this.categoryRepository.findAll();

    }
    // get category by ID
    public ResponseEntity<Category> getProductById(Long categoryID) 
    throws NotFoundException{
            Category category = categoryRepository.findById(categoryID)
                                .orElseThrow(() -> new NotFoundException(categoryID));
                return ResponseEntity.ok().body(category);
    }
    //Save
    public Category createCategory(Category newCategory){
                return this.categoryRepository.save(newCategory);  
    }
    //Update
    public ResponseEntity<Category> updateCategory(Long categoryID,Category categoryDetail){
            Category category = categoryRepository.findById(categoryID)
                                .orElseThrow(() -> new NotFoundException(categoryID));     
            category.setCategoryName(categoryDetail.getCategoryName());
            category.setCategoryDescription(categoryDetail.getCategoryDescription()); 
                return ResponseEntity.ok(this.categoryRepository.save(category));
    }
    //Delete Category
   
    public Map<String, Boolean> deleteCategory(Long categoryID){
            Category category = categoryRepository.findById(categoryID)
                                .orElseThrow(() -> new NotFoundException(categoryID));
            List<Product> listProduct = productService.findAllProductsByCategoryID(category.getCategoryID());
            if(listProduct.size() != 0){
                for (Product product : listProduct) {
                    productService.setCategoryOfProductIsDeleted(product);
            }
        }
            this.categoryRepository.delete(category);
            Map<String, Boolean> response = new HashMap<>();
            response.put("DELETED", Boolean.TRUE);

                return response;
    }
      
}