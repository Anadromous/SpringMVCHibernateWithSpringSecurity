package com.websystique.springmvc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.model.Cart;

@Service("cartService")
@Transactional
public interface CartService {
	
    Cart getCartById (int cartId);

    void update(Cart cart);

}
