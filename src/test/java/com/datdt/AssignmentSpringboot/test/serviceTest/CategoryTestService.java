package com.datdt.AssignmentSpringboot.test.serviceTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// import static org.hamcrest.CoreMatchers.is;
// import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.datdt.AssignmentSpringboot.entity.Category;
import com.datdt.AssignmentSpringboot.repository.CategoryRepository;
import com.datdt.AssignmentSpringboot.service.CategoryService;

import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

// import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class CategoryTestService {
    @Autowired
    private CategoryService categoryService;
    @MockBean
    private CategoryRepository categoryRepository;
    @MockBean
    Category category;
    // @InjectMocks
    // UserController uc;

    @Test
    public void getAllTest() throws Exception {
        List<Category> list = new ArrayList<>();
        Category cate1 = new Category(1L, "PC1", "ok");
        Category cate2 = new Category(2L, "PC2", "ok");
        list.add(cate1);
        list.add(cate2);
        when(categoryRepository.findAll()).thenReturn(list);    
        List<Category> categoriess = categoryService.getAllCategories();
        assertEquals(2,categoriess.size());
    }
    @Test 
    public void findByID() throws Exception{
        Category cate1 = new Category();
        cate1.setCategoryID(1L);
        cate1.setCategoryName("PC12");
        cate1.setCategoryDescription("nice");
        
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(cate1));    
        assertEquals(categoryService.getProductById(1L), 1);

    }
    @Test 
    public void saveCate() throws Exception{
        Long id= 2L;
        String CategoryName = "ASUS";
        String CategoryDes = "ASUS";
        category.setCategoryID(id);
        category.setCategoryName(CategoryName);
        category.setCategoryDescription(CategoryDes);
        assertEquals(categoryService.createCategory(category), null);
    }
    public void updateCate() throws Exception{
        Long id= 2L;
        String CategoryName = "ASUS";
        String CategoryDes = "ASUS";
        category.setCategoryID(id);
        category.setCategoryName(CategoryName);
        category.setCategoryDescription(CategoryDes);
        assertEquals(categoryService.createCategory(category), null);


    }       
    
        // @Test
//     // public void getCategoryByIdAPI() throws Exception {
//     //     mockMvc.perform(MockMvcRequestBuilders.
//     //     get("/categories/{id}", 1).accept(MediaType.APPLICATION_JSON))
//     //     .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.
//     //     jsonPath("$.categoryID").value(1));
//     // }
    }


