package com.datdt.AssignmentSpringboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.datdt.AssignmentSpringboot.entity.Product;
import com.datdt.AssignmentSpringboot.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/products")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)


public class ProductController{
    private final ProductService productService;

    @Autowired
        public ProductController(ProductService productService) {
            this.productService = productService;
        }
    //get Products
    // @PreAuthorize("hasRole('ROLE_CUSTOMER') or hasRole('ROLE_MANAGER')")
    @GetMapping("/")
        public List<Product> getAllProduct(){
            return (List<Product>) productService.getAllProduct(); 
        }
    //     @GetMapping("/")
    // public Page<Product> getAllProduct(@RequestParam("page") Optional<Integer> page,  @RequestParam("sortBy")Optional<String> sortBy){
    //     return (Page<Product>) productService.getAllProduct(page, sortBy);
    // }
    //get product by ID

    @GetMapping("/{id}")
        public ResponseEntity<Product> getProductByID(@PathVariable(value = "id") Long productID){
            return productService.getProductByID(productID);
        }
      //get product by categoryID
      @GetMapping("")
      @ResponseBody
      public List<Product> findAlProductsByCateId(@RequestParam("categoryid") String cateId){
          List<Product> productList = new ArrayList<>();
          try {
              long id = Long.parseLong(cateId);
              productList = productService.findAllProductsByCateId(id);
          } catch (Exception e) {
              e.getMessage();
          }
          return productList;
      }

    // create product
    @PostMapping("")
    public Product createProduct(@Valid @RequestBody Product newProduct, 
    @RequestParam("categoryid") long cateId) throws Exception{
        return productService.createProduct(newProduct, cateId);
    }

    //update product
    @PutMapping("/{id}")
        public ResponseEntity<Product> updateProduct(@PathVariable(value = "id")
         Long productID, @Valid @RequestBody Product productDetail){
            return productService.updateProduct(productID, productDetail);
        }
    //Delete products
    @DeleteMapping("/manager/{id}")
        public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productID){
            return productService.deleteProduct(productID);
        }
}