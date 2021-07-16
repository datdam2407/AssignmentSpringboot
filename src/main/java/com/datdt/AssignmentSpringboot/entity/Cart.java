package com.datdt.AssignmentSpringboot.entity;


import java.util.HashMap;

public class Cart {

    private HashMap<Long, Product> cart;

    public Cart() {
        this.cart = new HashMap<>();
    }

    public HashMap<Long, Product> getCart() {
        return cart;
    }

    public void setCart(HashMap<Long, Product> cart) {
        this.cart = cart;
    }

    public void addToCart(Product product) throws Exception{
		if(this.cart.containsKey(product.getProductID())){
			int newQuant = this.cart.get(product.getProductID()).getCartQuantity();
            newQuant++;
            this.cart.get(product.getProductID()).setCartQuantity(newQuant);
		} else{
            product.setCartQuantity(1);
			this.cart.put(product.getProductID(), product);
		}
	}

    public void remove(Long id) throws Exception {
		if(this.cart.containsKey(id)){
			this.cart.remove(id);
		}
	}

    public float getTotalofOrder() throws Exception{
		float result = 0;
		for(Product dto : this.cart.values()){
			result += dto.getCartQuantity() * dto.getProductPrice();
		}
		return result;
    }
    
}
