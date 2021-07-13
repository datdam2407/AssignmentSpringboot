// package com.datdt.AssignmentSpringboot.test;

// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;

// import com.datdt.AssignmentSpringboot.entity.Product;

// import com.datdt.AssignmentSpringboot.repository.ProductRepository;
// import com.datdt.AssignmentSpringboot.service.ProductService;

// import static org.hamcrest.CoreMatchers.is;
// import static org.junit.Assert.assertTrue;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.mockito.Mockito.when;
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
//         products.add(new Product("ASUS", "I7", new Date(), new Date(), 56000,"avaliable","sdahdkajdw", 11));
//         products.add(new Product("ASUsS", "I97", new Date(), new Date(), 56000,"avaliable","sdahdkajdw", 12));
//         products.add(new Product("ASUSe", "I78", new Date(), new Date(), 56000,"avaliable","sdahdkajdw", 13));
//     }
//     @Test
//     public void testListProduct()throws Exception{
//             when(productRepository.findAll()).thenReturn(this.products);
//             this.mockMvc.perform(get("/products/")).andExpect(status().isOk())
//             .andExpect(jsonPath("$.size()", is(products.size())));
//     }
//     // @Test
// 	// void testToEntity() {
// 	// 	// Give
// 	// 	Product dto = new Product("ASUS", "I7", new Date(), new Date(), 56000,"avaliable","sdahdkajdw", 11));
// 	// 	// Then
// 	// 	assertTrue(dto);
// 	// }
// }
