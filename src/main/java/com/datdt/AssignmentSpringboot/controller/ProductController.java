package com.datdt.AssignmentSpringboot.controller;

import java.util.List;
import java.util.Map;

import com.datdt.AssignmentSpringboot.entity.Product;
import com.datdt.AssignmentSpringboot.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController{
    private final ProductService productService;

    @Autowired
        public ProductController(ProductService productService) {
            this.productService = productService;
        }
    //get Products
    @GetMapping("/products")
        public List<Product> getAllProduct(){
            return (List<Product>) productService.getAllProduct(); 
        }
    //get product by ID
    @GetMapping("/products/{id}")
        public ResponseEntity<Product> getProductByID(@PathVariable(value = "id") Long productID){
            return productService.getProductByID(productID);
        }
      //get product by categoryID
    @GetMapping("/products/byID/{categoryid}")
        public List<Product> getAllProductsByCategoryID(@PathVariable(value = "id") Long categoryID){
            return productService.findAllProductsByCategoryID(categoryID);
        }
    // create product
    @PostMapping("/products")
        public Product createProduct(@RequestBody Product newProduct){
            return productService.createProduct(newProduct);
        }
    //update product
    @PutMapping("/products/{id}")
        public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productID,  @RequestBody Product productDetail){
            return productService.updateProduct(productID, productDetail);
        }
    //Delete products
    @DeleteMapping("/products/{id}")
        public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productID){
            return productService.deleteProduct(productID);
        }
}