package com.datdt.AssignmentSpringboot.test.serviceTest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
// import java.util.ArrayList;
// import java.util.Date;
import java.util.List;
// import java.util.Map;
// import java.util.Optional;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.datdt.AssignmentSpringboot.entity.Cart;
import com.datdt.AssignmentSpringboot.entity.Product;
import com.datdt.AssignmentSpringboot.repository.ProductRepository;
import com.datdt.AssignmentSpringboot.service.CartService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;


// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
public class CartServiceTest {
    @Autowired
    private CartService cartService;
    @MockBean
    private ProductRepository productRepository;
    @MockBean
    Cart cart;
    
    public static final Long PRODUCTID = 1L;
    public HttpServletRequest request;

    List<Product> list;


    @BeforeEach
    public void setUp(){
        list = new ArrayList<>();
        Product product = new Product("ASUS", "CoreI7", new Date(), new Date(),15000000,"Avaliable","abc.img", 11);
        list.add(product);
    }
    @Test
    public void addProductToCart_ThenReturnCart() throws Exception {
        
        Optional<Product> optional = Optional.of(list.get(0));
        assertNotNull(optional);
        when(productRepository.findById(PRODUCTID)).thenReturn(optional);
        Cart shoppingCart = (Cart) request.getSession().getAttribute("shCart");
        shoppingCart = new Cart();
        shoppingCart.addToCart(list.get(0));
        request.getSession().setAttribute("shCart", shoppingCart);
        cartService.addProductToCart(PRODUCTID, request);
    }


    @Test
    public void removeProductCart_thenDeleteProdutcfromCartShouldBeFound(HttpServletRequest request) throws Exception {

        Product product = new Product();
        Optional<Product> optional = Optional.of(product);
 
         // (1L,"ASUS", "CoreI7", new Date(), new Date(),15000000,"Avaliable","abc.img", 11);
         // list.add(product);
         assertNotNull(optional);
         when(productRepository.findById(PRODUCTID)).thenReturn(optional);
         cartService.removeProductFromCart(PRODUCTID, request);

    }
}
