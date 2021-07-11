package com.datdt.AssignmentSpringboot.test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
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
    // this.categories = new ArrayList<>();
    // this.categories.add(new Category(1, "PC1", "ok"));
    // this.categories.add(new Category(2, "PC2", "ok"));
    // // this.categories.add(new Category(3, "PC3", "ok"));
    // }
    @Test
    // @WithMockUser(username ="ROLE_CUSTOMER")
    public void getAllTest() throws Exception {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "PC1", "ok"));
        categories.add(new Category(2, "PC2", "ok"));
        categories.add(new Category(3, "PC3", "ok"));
        categories.add(new Category(4, "PC4", "ok"));
        Mockito.when(categoryService.getAllCategories()).thenReturn(categories);
        mockMvc.perform(get("/categories/")).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void getAllCategoryAPI() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/categories/")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.categories").exists())
        .andExpect(MockMvcResultMatchers.jsonPath("$.categories[*].categoryID")
        .isNotEmpty());
    }

    @Test
    public void getCategoryByIdAPI() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.
        get("/categories/{id}", 1).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.
        jsonPath("$.categoryID").value(1));
    }

    @Test
    public void createCategoryAPI() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/categories/").content(asJsonString(new Category(1, "PC2", "ok")))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andExpect(MockMvcResultMatchers.jsonPath("$.categoryID").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void updateCategoryAPI() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/categories/{id}", 1)
                .content(asJsonString(new Category(1, "Laptop", "okla"))).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.PC2").value("Laptop"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ok").value("okla"));
    }

    @Test
    public void deleteCategoryAPI() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/categories/{id}", 1)).andExpect(status().isAccepted());
    }
    // @Test
    // public void testCreateCategory() {
    // Category newcCategory = new Category("PCc", "djawj");
    // Category saveCategory = new Category(1, "PCc", "djawj");
    // Mockito.when(categoryRepository.save(newcCategory)).thenReturn(saveCategory);

    // String url = "/categories/";
    // mockMvc.perform(post(url)).contentType("application/json")
    // .content(objectMapper.writeValueAsString(newcCategory)).andExpect(status().isOk())
    // .andExpect(content().string("1"));
    // ;

    // }

    // @Test
    // public void testCategoryName_Not_Be_Blank() {

    // }

}
