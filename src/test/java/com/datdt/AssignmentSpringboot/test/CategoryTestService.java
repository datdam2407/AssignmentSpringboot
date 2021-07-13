package com.datdt.AssignmentSpringboot.test;

import java.util.ArrayList;
import java.util.List;

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

@SpringBootTest
public class CategoryTestService {
    @Autowired
    private CategoryService categoryService;
    @MockBean
    private CategoryRepository categoryRepository;
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
}