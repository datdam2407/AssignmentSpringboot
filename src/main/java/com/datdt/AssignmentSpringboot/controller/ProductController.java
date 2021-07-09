package com.datdt.AssignmentSpringboot.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/public/products")
@RestController
public class ProductController{
    private final ProductService productService;

    @Autowired
        public ProductController(ProductService productService) {
            this.productService = productService;
        }
    //get Products
    @GetMapping("/")
        public List<Product> getAllProduct(){
            return (List<Product>) productService.getAllProduct(); 
        }
    //get product by ID
    @GetMapping("/{id}")
        public ResponseEntity<Product> getProductByID(@PathVariable(value = "id") Long productID){
            return productService.getProductByID(productID);
        }
      //get product by categoryID
    @GetMapping("?bycategoryid={categoryid}")
        public List<Product> getAllProductsByCategoryID(@RequestParam(value = "categoryID") String categoryID){
            List<Product> listProduct = new ArrayList<>();
                try {
                    long cateid = Long.parseLong(categoryID);
                    listProduct = productService.findAllProductsByCategoryID(cateid);
                } catch (Exception ex) {
                    ex.getMessage();
                }
            return listProduct;
        }
    // create product
    @PostMapping("/")
        public Product createProduct(@RequestBody Product newProduct){
            return productService.createProduct(newProduct);
        }
    //update product
    @PutMapping("/{id}")
        public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productID,  @RequestBody Product productDetail){
            return productService.updateProduct(productID, productDetail);
        }
    //Delete products
    @DeleteMapping("/{id}")
        public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productID){
            return productService.deleteProduct(productID);
        }
}