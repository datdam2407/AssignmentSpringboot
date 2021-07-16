// package com.datdt.AssignmentSpringboot.test.serviceTest;

// import static org.junit.Assert.assertNotNull;
// import static org.mockito.Mockito.when;

// // import java.util.ArrayList;
// // import java.util.Date;
// import java.util.List;
// // import java.util.Map;
// // import java.util.Optional;
// import java.util.Optional;

// import javax.servlet.http.HttpServletRequest;

// // import static org.junit.jupiter.api.Assertions.assertEquals;
// // import static org.junit.jupiter.api.Assertions.assertNotNull;

// import com.datdt.AssignmentSpringboot.entity.Cart;
// import com.datdt.AssignmentSpringboot.entity.Product;
// import com.datdt.AssignmentSpringboot.repository.ProductRepository;
// import com.datdt.AssignmentSpringboot.service.CartService;

// import org.junit.jupiter.api.Test;

// // import static org.mockito.Mockito.times;
// // import static org.mockito.Mockito.verify;
// // import static org.mockito.Mockito.when;


// // import org.junit.jupiter.api.BeforeEach;
// // import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;


// @SpringBootTest
// public class CartServiceTest {
//     @Autowired
//     private CartService cartService;
//     @MockBean
//     private ProductRepository productRepository;
//     @MockBean
//     Cart cart;
    
//     public static final Long PRODUCTID = 1L;
//     public HttpServletRequest request ;

//     List<Product> list;



//     @Test
//     public void addProductToCart_ThenReturnCart() throws Exception {
//         Product product = new Product();
//        Optional<Product> optional = Optional.of(product);

//         // (1L,"ASUS", "CoreI7", new Date(), new Date(),15000000,"Avaliable","abc.img", 11);
//         // list.add(product);
//         assertNotNull(optional);
//         when(productRepository.findById(PRODUCTID)).thenReturn(optional);
//         equals(cartService.addProductToCart(product.getProductID(), request));
//     }

//     @Test
//     public void updateCate_ThenReturnCategory() throws Exception {
//         Category cate = new Category();
//         Long CateID = 1L;
//         Optional<Category> optional = Optional.of(cate);
//         assertNotNull(optional);
//         when(categoryRepository.findById(CateID)).thenReturn(optional);
//         when(categoryRepository.save(optional.get())).thenReturn(cate);
//         ResponseEntity<Category> cate2 = categoryService.updateCategory(CateID, cate);
//         assertEquals(cate2.getBody().getCategoryName(), cate.getCategoryName());
//     }

//     @Test
//     public void whenValidID_thenDeleteCategoryShouldBeFound() throws Exception {

//         Category cate = new Category();
//         Long CateID = 1L;
//         Optional<Category> optional = Optional.of(cate);
//         assertNotNull(optional);
//         when(categoryRepository.findById(CateID)).thenReturn(optional);
//         Map<String, Boolean> cate2 = categoryService.deleteCategory(CateID);
//         assertEquals(cate2.equals(true), false);

//     }
// }
