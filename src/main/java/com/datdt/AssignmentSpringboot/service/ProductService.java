package com.datdt.AssignmentSpringboot.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.datdt.AssignmentSpringboot.entity.Product;
import com.datdt.AssignmentSpringboot.exception.ProductException;
import com.datdt.AssignmentSpringboot.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
 
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProduct(){
            return this.productRepository.findAll();    
    }
    //get product by ID
    public ResponseEntity<Product> getProductByID(Long productID)throws ProductException{
        Product product = productRepository.findById(productID)
                .orElseThrow(() -> new ProductException(productID));
            return ResponseEntity.ok().body(product);
    }
    // create product
    
    public Product createProduct(Product product){
            return this.productRepository.save(product);  
    }
    
    //update product
    public ResponseEntity<Product> updateProduct(Long productID, Product productDetail){
        Product product = productRepository.findById(productID)
                .orElseThrow(() -> new ProductException(productID));     
            product.setProductName(productDetail.getProductName());
            product.setProductDiscription(productDetail.getProductDiscription());
            product.setProductImage(productDetail.getProductImage());
            product.setCategory(productDetail.getCategory());
            product.setProductStatus(productDetail.getProductStatus());
            product.setProductPrice(productDetail.getProductPrice());
            Date currentDate = new Date();
            product.setUpdateDate(currentDate);
            return ResponseEntity.ok(this.productRepository.save(product));
    }
    //Delete products
    public Map<String, Boolean> deleteProduct(Long productID){
        Product product = productRepository.findById(productID)
                .orElseThrow(() -> new ProductException(productID));
            this.productRepository.delete(product);
            Map<String, Boolean> response = new HashMap<>();
            response.put("DELETED", Boolean.TRUE);
            return response;
    }

    //Find product by categoryID
    public List<Product> findAllProductsByCategoryID(long categoryID){
            return this.productRepository.findAllProductsByCategoryID(categoryID);
    }
    //
    public Map<String, Boolean> setCategoryOfProductIsDeleted(Product product){
            product.setCategory(null);
            this.productRepository.save(product);
            Map<String, Boolean> response = new HashMap<>();
            response.put("Set NULL", Boolean.TRUE);
            return response;
    }
}

