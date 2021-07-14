package com.datdt.AssignmentSpringboot.test.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.datdt.AssignmentSpringboot.entity.Product;
import com.datdt.AssignmentSpringboot.repository.ProductRepository;
import com.datdt.AssignmentSpringboot.service.ProductService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ProductTestService {
    @Autowired
    private ProductService productService;
    @MockBean
    private ProductRepository productRepository;
    @MockBean
    Product product;

    @Test
    public void getAllTest() throws Exception {
        List<Product> list = new ArrayList<>();
        Product product1 = new Product("Assus gaming", "aloha", new Date(), new Date(), 15000, "alive", "dwan.img", 11);
        Product product2 = new Product("MSI gaming", "alsoha", new Date(), new Date(), 22000, "alive", "dwsssan.img",
                9);
        list.add(product1);
        list.add(product2);
        when(productRepository.findAll()).thenReturn(list);
        List<Product> listProducts = productService.getAllProduct();
        assertEquals(2, listProducts.size());
    }

    @Test
    public void saveProduct() throws Exception {
        Long id = 2L;
        String ProductName = "ASUS";
        String ProductDiscription = "ok formal";
        float ProductPrice = 1550;
        String setProductImage = "asdd.img";
        int ProductQuantity = 11;
        product.setProductID(id);
        product.setProductName(ProductName);
        product.setProductDiscription(ProductDiscription);
        product.setProductPrice(ProductPrice);
        product.setProductImage(setProductImage);
        product.setProductQuantity(ProductQuantity);
        assertEquals(productService.createProduct(product), null);
    }
    @Test
    public void findByID() throws Exception{
    Product product = new Product();
    product.setProductName("Auss gaming");
    product.setProductDiscription("nice");
    product.setCreateDate(new Date());
    product.setProductPrice(15000);
    product.setProductImage("dwjakjdkwaj");
    product.setProductQuantity(11);

    when(productRepository.findById(1L)).thenReturn(Optional.of(product));
    assertEquals(productService.getProductByID(1L), 1);

    }
}
