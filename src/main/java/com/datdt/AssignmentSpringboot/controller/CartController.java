package com.datdt.AssignmentSpringboot.controller;

import javax.servlet.http.HttpServletRequest;

import com.datdt.AssignmentSpringboot.entity.Cart;
import com.datdt.AssignmentSpringboot.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*", maxAge = 3600)

public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("")
    public Cart addProductToCart(@RequestParam("productId") long productId, HttpServletRequest request) throws Exception{
        return this.cartService.addProductToCart(productId, request);
    }

    @DeleteMapping("")
    public Cart removeProductFromCart(@RequestParam("productId") Long productId, HttpServletRequest request) throws Exception{
        return this.cartService.removeProductFromCart(productId, request);
    }

    
}
