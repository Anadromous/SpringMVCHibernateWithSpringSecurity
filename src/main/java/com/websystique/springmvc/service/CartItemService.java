package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Cart;
import com.websystique.springmvc.model.CartItem;

/**
 * Created by Le on 1/25/2016.
 */
public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId (int productId);
}
