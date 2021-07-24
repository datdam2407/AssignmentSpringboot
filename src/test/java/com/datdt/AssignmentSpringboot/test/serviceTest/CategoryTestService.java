package com.datdt.AssignmentSpringboot.test.serviceTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.datdt.AssignmentSpringboot.entity.Category;
import com.datdt.AssignmentSpringboot.repository.CategoryRepository;
import com.datdt.AssignmentSpringboot.service.CategoryService;

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
public class CategoryTestService {
    @Autowired
    private CategoryService categoryService;
    @MockBean
    private CategoryRepository categoryRepository;
    @MockBean
    Category category;
    public static final String CATENAME = "CATENAME";
    
    List<Category> list;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>();
        Category cate1 = new Category(1L, "PC1", "ok");
        Category cate2 = new Category(2L, "PC2", "ok");
        Category cate3 = new Category(3L, "PC2", "ok");
        list.add(cate1);
        list.add(cate2);
        list.add(cate3);
    }

    @Test
    public void getAllTest_returnCateList() throws Exception {
        when(categoryRepository.findAll()).thenReturn(list);
        assertEquals(categoryService.getAllCategories(), list);
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    public void whenValidID_thenCategoryShouldBeFound() throws Exception {

        Category cate = new Category();
        Long CateID = 1L;
        Optional<Category> optional = Optional.of(cate);
        assertNotNull(optional);
        when(categoryRepository.findById(CateID)).thenReturn(optional);
        ResponseEntity<Category> cate2 = categoryService.getProductById(CateID);
        assertEquals(cate2.getBody().getCategoryName(), cate.getCategoryName());
    }
    @Test
    public void saveCate_ThenReturnCategory() throws Exception {
        when(categoryRepository.save(list.get(0))).thenReturn(list.get(0));
        assertEquals(categoryService.createCategory(list.get(0)), list.get(0));
    }

    @Test
    public void updateCate_ThenReturnCategory() throws Exception {
        Category cate = new Category();
        Long CateID = 1L;
        Optional<Category> optional = Optional.of(cate);
        assertNotNull(optional);
        when(categoryRepository.findById(CateID)).thenReturn(optional);
        when(categoryRepository.save(optional.get())).thenReturn(cate);
        ResponseEntity<Category> cate2 = categoryService.updateCategory(CateID, cate);
        assertEquals(cate2.getBody().getCategoryName(), cate.getCategoryName());
    }

    @Test
    public void whenValidID_thenDeleteCategoryShouldBeFound() throws Exception {

        Category cate = new Category();
        Long CateID = 1L;
        Optional<Category> optional = Optional.of(cate);
        assertNotNull(optional);
        when(categoryRepository.findById(CateID)).thenReturn(optional);
        Map<String, Boolean> cate2 = categoryService.deleteCategory(CateID);
        System.out.println(cate2);
    }
}
