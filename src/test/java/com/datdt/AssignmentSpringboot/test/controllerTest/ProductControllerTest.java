package com.datdt.AssignmentSpringboot.test.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import com.datdt.AssignmentSpringboot.AssignmentSpringbootApplication;
import com.datdt.AssignmentSpringboot.entity.Product;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)


@SpringBootTest(classes = AssignmentSpringbootApplication.class,
 webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {
     @Autowired
     private TestRestTemplate restTemplate;

     @LocalServerPort
     private int port = 5432;

     private String getRootUrl() {
         return "http://localhost:" + port;
     }

     @Test
     public void testGetAllEmployees_ReturnBody() {
     HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/products/",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }
    @Test
    public void testGetEmployeeById_ThrowNotNull() {
        Product product = restTemplate.getForObject(getRootUrl() 
        + "/products/1", Product.class);
        System.out.println(product.getProductName());
        assertNotNull(product);
    }
    @Test
    public void testCreateProduct() {
        Product product = new Product();
        product.setProductID(1L);
        product.setProductName("Auss gaming");
        product.setProductDiscription("nice");
        product.setCreateDate(new Date());
        product.setUpdateDate(new Date());
        product.setProductPrice(15000);
        product.setProductStatus("alive");
        product.setProductImage("dwjakjdkwaj");
        product.setProductQuantity(11);
        ResponseEntity<Product> postResponse = restTemplate.postForEntity(getRootUrl() 
        + "/public/products/", product, Product.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }
    @Test
    public void testUpdateProducts_ThrowNotNUll() {
        int id = 1;
        Product product = restTemplate.getForObject(getRootUrl() + "/products/" + id, Product.class);
        product.setProductName("MSI 2020");
        product.setProductQuantity(22);
        restTemplate.put(getRootUrl() + "/products/" + id, product);
        Product updatedProduct = restTemplate.getForObject(getRootUrl() + "/products/" + id, Product.class);
        assertNotNull(updatedProduct);
    }
    @Test
    public void testDeleteProduct_ThrowNOtFound() {
         int id = 2;
         Product product = restTemplate.getForObject(getRootUrl() + "/products/" + id, Product.class);
         assertNotNull(product);
         restTemplate.delete(getRootUrl() + "/products/" + id);
         try {
              product = restTemplate.getForObject(getRootUrl() + "/products/" + id, Product.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
}
