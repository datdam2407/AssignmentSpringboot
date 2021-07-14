package com.datdt.AssignmentSpringboot.test.controllerTest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import com.datdt.AssignmentSpringboot.AssignmentSpringbootApplication;
import com.datdt.AssignmentSpringboot.entity.Cart;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AssignmentSpringbootApplication.class,
 webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CartControllerTest {
     @Autowired
     private TestRestTemplate restTemplate;

     @LocalServerPort
     private int port = 5432;

     private String getRootUrl() {
         return "http://localhost:" + port;
     }

     @Test
     public void testAddProduct_ThrowNOtFound() {
          Long id = 2L;
        Cart addProducCart = restTemplate.getForObject(getRootUrl() + "/cart/" + id, 
        Cart.class);
         
        ResponseEntity<Cart> postResponse = restTemplate.postForEntity(getRootUrl() 
        + "/public/cart/", addProducCart, Cart.class);
          try {
            addProducCart = restTemplate.getForObject(getRootUrl() + "/cart/" + id, Cart.class);
            assertNotNull(postResponse);
            assertNotNull(postResponse.getBody()); 
        } catch (final HttpClientErrorException e) {
               assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
          }
     }
  
    @Test
    public void testDeleteProduct_ThrowNOtFound() {
         Long id = 2L;
         Cart removeProductCart = restTemplate.getForObject(getRootUrl() + "/cart/" + id, Cart.class);
         assertNotNull(removeProductCart);
         restTemplate.delete(getRootUrl() + "/cart/" + id);
         try {
            removeProductCart = restTemplate.getForObject(getRootUrl() + "/cart/" + id, Cart.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
}

