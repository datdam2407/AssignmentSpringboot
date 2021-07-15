package com.datdt.AssignmentSpringboot.test.serviceTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.datdt.AssignmentSpringboot.entity.Product;
import com.datdt.AssignmentSpringboot.repository.ProductRepository;
import com.datdt.AssignmentSpringboot.service.ProductService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class ProductTestService {
    @Autowired
    private ProductService productService;
    @MockBean
    private ProductRepository productRepository;
    @MockBean
    Product product;
    public static final String PRODUCTNAME = "PRODUCTNAME";
    public static final Long PRODUCTID = 1L;
    
    List<Product> list;

    @BeforeEach
    public void setUpProduct() {
        list = new ArrayList<>();
        Product product = new Product("ASUS", "CoreI7", new Date(), new Date(),15000000,"Avaliable","abc.img", 11);
        Product product2 = new Product("MSI RF", "CoreI7, 8RC", new Date(), new Date(),17000000,"Avaliable","abcd.img", 9);
        Product product3 = new Product("MSI RC", "CoreI7, coolder boost 5", new Date(), new Date(),19000000,"Avaliable","abce.img", 7);
        list.add(product);
        list.add(product2);
        list.add(product3);
    }

    @Test
    public void getAllTest_returnProductList() throws Exception {
        when(productRepository.findAll()).thenReturn(list);
        assertEquals(productService.getAllProduct(), list);
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void whenValidID_thenProductShouldBeFound() throws Exception {

        Product product = new Product();
        Optional<Product> optional = Optional.of(product);
        assertNotNull(optional);
        when(productRepository.findById(PRODUCTID)).thenReturn(optional);
        ResponseEntity<Product> product2 = productService.getProductByID(PRODUCTID);
        assertEquals(product2.getBody().getProductName(), product.getProductName());
    }
    @Test
    public void createProduct_ThenReturnProduct() throws Exception {
        when(productRepository.save(list.get(0))).thenReturn(list.get(0));
        assertEquals(productService.createProduct(list.get(0)), list.get(0));
    }

    @Test
    public void updateProduct_ThenReturnNewProduct() throws Exception {
        Product newProduct = new Product();
        Optional<Product> optional = Optional.of(product);
        assertNotNull(optional);
        when(productRepository.findById(PRODUCTID)).thenReturn(optional);
        when(productRepository.save(optional.get())).thenReturn(product);
        ResponseEntity<Product> product2 = productService.updateProduct(PRODUCTID, newProduct);
        assertEquals(product2.getBody().getProductName(), newProduct.getProductName());
    }

    @Test
    public void whenValidID_thenDeleteProductShouldBeFound() throws Exception {

        Product Product = new Product();
        Optional<Product> optional = Optional.of(Product);
        assertNotNull(optional);
        when(productRepository.findById(PRODUCTID)).thenReturn(optional);
        Map<String, Boolean> product = productService.deleteProduct(PRODUCTID);
        assertEquals(product.equals(true), false);
    }

}
