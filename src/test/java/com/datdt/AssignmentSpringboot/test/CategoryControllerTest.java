// package com.datdt.AssignmentSpringboot.test;

// import java.util.ArrayList;
// import java.util.List;

// import static org.hamcrest.CoreMatchers.is;
// import static org.junit.Assert.assertThat;
// import static org.junit.jupiter.api.Assertions.assertEquals;

// import com.datdt.AssignmentSpringboot.controller.CategoryController;
// import com.datdt.AssignmentSpringboot.entity.Category;
// import com.datdt.AssignmentSpringboot.repository.CategoryRepository;
// import com.datdt.AssignmentSpringboot.service.CategoryService;

// import static org.mockito.Mockito.when;
// // import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// // import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// // import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
// // import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.web.servlet.MockMvc;


// // @WebMvcTest(CategoryController.class)
// // @AutoConfigureMockMvc(addFilters = false)
// @SpringBootTest
// public class CategoryControllerTest {

//     @Autowired
//     private MockMvc mockMvc;

//     @Autowired
//     private CategoryService categoryService;

//     @MockBean
//     private CategoryRepository categoryRepository;
//     @Test
//     public void getAllTest() throws Exception {
//         List<Category> list = new ArrayList<>();
//         Category cate1 = new Category(1L, "PC1", "ok");
//         Category cate2 = new Category(2L, "PC2", "ok");
//         list.add(cate1);
//         list.add(cate2);

//         when(categoryRepository.findAll()).thenReturn(list);
        
//         List<Category> categoriess = categoryService.getAllCategories();
        
//         assertEquals(2,categoriess.size());
//     }

//     // @Test
//     // public void getAllCategoryAPI() throws Exception {
//     //     mockMvc.perform(MockMvcRequestBuilders.get("/categories/")
//     //     .accept(MediaType.APPLICATION_JSON))
//     //     .andExpect(status().isOk())
//     //     .andExpect(MockMvcResultMatchers.jsonPath("$.categories").exists())
//     //     .andExpect(MockMvcResultMatchers.jsonPath("$.categories[*].categoryID")
//     //     .isNotEmpty());
//     // }

//     // @Test
//     // public void getCategoryByIdAPI() throws Exception {
//     //     mockMvc.perform(MockMvcRequestBuilders.
//     //     get("/categories/{id}", 1).accept(MediaType.APPLICATION_JSON))
//     //     .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.
//     //     jsonPath("$.categoryID").value(1));
//     // }

//     // @Test
//     // public void createCategoryAPI() throws Exception {
//     //     mockMvc.perform(MockMvcRequestBuilders.post("/categories/").content(asJsonString(new Category(1, "PC2", "ok")))
//     //             .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
//     //             .andExpect(status().isCreated()).andExpect(MockMvcResultMatchers.jsonPath("$.categoryID").exists());
//     // }

//     // public static String asJsonString(final Object obj) {
//     //     try {
//     //         return new ObjectMapper().writeValueAsString(obj);
//     //     } catch (Exception e) {
//     //         throw new RuntimeException(e);
//     //     }
//     // }

//     // @Test
//     // public void updateCategoryAPI() throws Exception {
//     //     mockMvc.perform(MockMvcRequestBuilders.put("/categories/{id}", 1)
//     //             .content(asJsonString(new Category(1, "Laptop", "okla"))).contentType(MediaType.APPLICATION_JSON)
//     //             .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//     //             .andExpect(MockMvcResultMatchers.jsonPath("$.PC2").value("Laptop"))
//     //             .andExpect(MockMvcResultMatchers.jsonPath("$.ok").value("okla"));
//     // }

//     // @Test
//     // public void deleteCategoryAPI() throws Exception {
//     //     mockMvc.perform(MockMvcRequestBuilders.delete("/categories/{id}", 1)).andExpect(status().isAccepted());
//     // }
//     // @Test
//     // public void testCreateCategory() {
//     // Category newcCategory = new Category("PCc", "djawj");
//     // Category saveCategory = new Category(1, "PCc", "djawj");
//     // Mockito.when(categoryRepository.save(newcCategory)).thenReturn(saveCategory);

//     // String url = "/categories/";
//     // mockMvc.perform(post(url)).contentType("application/json")
//     // .content(objectMapper.writeValueAsString(newcCategory)).andExpect(status().isOk())
//     // .andExpect(content().string("1"));
//     // ;

//     // }

//     // @Test
//     // public void testCategoryName_Not_Be_Blank() {

//     // }

// }
