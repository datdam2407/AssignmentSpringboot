package com.datdt.AssignmentSpringboot.test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.datdt.AssignmentSpringboot.controller.CategoryController;
import com.datdt.AssignmentSpringboot.entity.Category;
import com.datdt.AssignmentSpringboot.repository.CategoryRepository;
// import com.datdt.AssignmentSpringboot.service.CategoryService;
import com.datdt.AssignmentSpringboot.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CategoryController.class)
@AutoConfigureMockMvc(addFilters = false)
public class CategoryControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
 
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CategoryService categoryService;

    @MockBean 
    private CategoryRepository categoryRepository;


    // @BeforeEach
    // void setUp(){
    //     this.categories = new ArrayList<>();
    //     this.categories.add(new Category(1, "PC1", "ok"));
    //     this.categories.add(new Category(2, "PC2", "ok"));
    //     // this.categories.add(new Category(3, "PC3", "ok"));
    // }
    @Test
	// @WithMockUser(username  ="ROLE_CUSTOMER")
	public void getAllTest() throws Exception {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "PC1", "ok"));
        categories.add(new Category(2, "PC2", "ok"));
        categories.add(new Category(3, "PC3", "ok"));
        categories.add(new Category(4, "PC4", "ok"));
        Mockito.when(categoryRepository.findAll()).thenReturn(categories);
        this.mockMvc.perform(get("/categories/")).andExpect(status().isOk()).andReturn();

    	}
  
}
