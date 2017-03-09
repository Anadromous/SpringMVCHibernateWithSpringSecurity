package com.websystique.springmvc.dao;

import java.io.IOException;

import com.websystique.springmvc.model.Cart;

/**
 * Created by Le on 1/11/2016.
 */
public interface CartDao {

    Cart getCartById (int cartId);

    Cart validate(int cartId) throws IOException;

    void update(Cart cart);
}
