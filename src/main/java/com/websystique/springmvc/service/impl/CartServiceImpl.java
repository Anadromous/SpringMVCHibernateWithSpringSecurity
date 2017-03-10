package com.websystique.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.CartDao;
import com.websystique.springmvc.model.Cart;
import com.websystique.springmvc.service.CartService;

/**
 * Created by pchapman on 1/25/2017.
 */

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    public void update(Cart cart) {
        cartDao.update(cart);
    }
}
