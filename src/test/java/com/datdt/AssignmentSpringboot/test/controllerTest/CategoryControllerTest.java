package com.datdt.AssignmentSpringboot.test.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import com.datdt.AssignmentSpringboot.AssignmentSpringbootApplication;
import com.datdt.AssignmentSpringboot.entity.Category;

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
public class CategoryControllerTest {
     @Autowired
     private TestRestTemplate restTemplate;

     @LocalServerPort
     private int port = 5432;

     private String getRootUrl() {
         return "http://localhost:" + port;
     }

     @Test
     public void testGetAllCategories_ReturnBody() {
     HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/categories/",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }
    @Test
    public void testGetCategoryById_ThrowNotNull() {
        Category category = restTemplate.getForObject(getRootUrl() 
        + "/categories/1", Category.class);
        System.out.println(category.getCategoryName());
        assertNotNull(category);
    }
    @Test
    public void testCreateCategory() {
        Category category = new Category();
        category.setCategoryID(1L);
        category.setCategoryName("PC");
        category.setCategoryDescription("nice");
      
        ResponseEntity<Category> postResponse = restTemplate.postForEntity(getRootUrl() 
        + "/public/categories/", category, Category.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }
    @Test
    public void testUpdateCate_ThrowNotNUll() {
        Long id = 1L;
        Category category = restTemplate.getForObject(getRootUrl() + "/categories/" + id, Category.class);
        category.setCategoryName("IPhone");
        category.setCategoryDescription("luxury");
        restTemplate.put(getRootUrl() + "/products/" + id, category);
        Category updatedCategory = restTemplate.getForObject(getRootUrl() + "/categories/" + id, Category.class);
        assertNotNull(updatedCategory);
    }
    @Test
    public void testDeleteCate_ThrowNOtFound() {
         Long id = 2L;
         Category category = restTemplate.getForObject(getRootUrl() + "/categories/" + id, Category.class);
         assertNotNull(category);
         restTemplate.delete(getRootUrl() + "/categories/" + id);
         try {
            category = restTemplate.getForObject(getRootUrl() + "/categories/" + id, Category.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
}
