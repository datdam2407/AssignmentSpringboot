package com.datdt.AssignmentSpringboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.datdt.AssignmentSpringboot.entity.Product;
import com.datdt.AssignmentSpringboot.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/products")
@RestController
public class ProductController{
    private final ProductService productService;

    @Autowired
        public ProductController(ProductService productService) {
            this.productService = productService;
        }
    //get Products
    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER','ROLE_MANAGER')")
    // @PreAuthorize("hasRole('ROLE_CUSTOMER') or hasRole('ROLE_MANAGER')")
    @GetMapping("/")
        public List<Product> getAllProduct(){
            return (List<Product>) productService.getAllProduct(); 
        }
    //get product by ID
    @PreAuthorize("hasRole('ROLE_CUSTOMER') or hasRole('ROLE_MANAGER')")

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
    @PreAuthorize("hasAuthority('ROLE_MANAGER')")
    @PostMapping("/manager")
        public Product createProduct(@Valid @RequestBody Product newProduct){
            return productService.createProduct(newProduct);
        }
    //update product
    @PreAuthorize("hasAuthority('ROLE_MANAGER')")
    @PutMapping("/manager/{id}")
        public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productID, @Valid @RequestBody Product productDetail){
            return productService.updateProduct(productID, productDetail);
        }
    //Delete products
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @DeleteMapping("/manager/{id}")
        public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productID){
            return productService.deleteProduct(productID);
        }
}