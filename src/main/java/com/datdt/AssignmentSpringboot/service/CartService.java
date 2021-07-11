package com.datdt.AssignmentSpringboot.service;

import javax.servlet.http.HttpServletRequest;

import com.datdt.AssignmentSpringboot.entity.Cart;
import com.datdt.AssignmentSpringboot.entity.Product;
import com.datdt.AssignmentSpringboot.exception.NotFoundException;
import com.datdt.AssignmentSpringboot.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    
    private final ProductRepository productRepository;

    @Autowired
    public CartService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Cart addProductToCart(long productId,HttpServletRequest request) throws Exception{
        Product newProduct = productRepository.findById(productId)
                                              .orElseThrow(() -> new NotFoundException(productId));
        Cart shoppingCart = (Cart) request.getSession().getAttribute("Cart");
        if(shoppingCart == null){
            shoppingCart = new Cart();
        }
        shoppingCart.addToCart(newProduct);

        request.getSession().setAttribute("Cart", shoppingCart);
        return shoppingCart; 
    }
    

    public Cart removeProductFromCart(long productId, HttpServletRequest request) throws Exception{ 
        Cart shoppingCart = (Cart) request.getSession().getAttribute("Cart");

        shoppingCart.remove(productId);

        request.getSession().setAttribute("Cart", shoppingCart);
        return shoppingCart;
    }
    
}
