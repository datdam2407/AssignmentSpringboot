// package com.datdt.AssignmentSpringboot.test;

// import java.util.ArrayList;
// import java.util.List;

// import com.datdt.AssignmentSpringboot.entity.Product;

// import com.datdt.AssignmentSpringboot.repository.ProductRepository;
// import com.datdt.AssignmentSpringboot.service.ProductService;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.web.servlet.MockMvc;

// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


// public class ProductControllerTest {
    
//     @Autowired
//     private MockMvc mockMvc;
 
//     @Autowired
//     private ProductService productService;

//     @MockBean 
//     private ProductRepository productRepository;

//     private List<Product> products;

//     @BeforeEach
//     void setUp(){
//         this.products = new ArrayList<>();
//         products.add(new );

//     }
//     // @Test
//     // public void testListCategory()throws Exception{
//     //         when(categoryService.getAllCategories()).thenReturn(this.categories);
//     //         this.mockMvc.perform(get("/api/public/categories")).andExpect(status().isOk());
//     // }
    
// }
