package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Cart;

public interface CartService {
	
    Cart getCartById (int cartId);

    void update(Cart cart);

}
