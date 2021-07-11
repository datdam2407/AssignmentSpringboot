package com.datdt.AssignmentSpringboot.unittest;

import java.util.ArrayList;
import java.util.List;

import com.datdt.AssignmentSpringboot.controller.CategoryController;
import com.datdt.AssignmentSpringboot.entity.Category;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.datdt.AssignmentSpringboot.repository.CategoryRepository;
import com.datdt.AssignmentSpringboot.service.CategoryService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


public class CategoryControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
 
    @Autowired
    private CategoryService categoryService;

    @MockBean 
    private CategoryRepository categoryRepository;

    private List<Category> categories;

    @BeforeEach
    void setUp(){
        this.categories = new ArrayList<>();
        categories.add(new Category("PC", "Formal"));
        categories.add(new Category("PC2", "Nice"));
        categories.add(new Category("PC3", "Formal2"));
    }
    @Test
    public void testListCategory()throws Exception{
            when(categoryService.getAllCategories()).thenReturn(this.categories);
            this.mockMvc.perform(get("/api/public/categories")).andExpect(status().isOk());
    }




}
