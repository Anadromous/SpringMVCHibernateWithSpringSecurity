package com.websystique.springmvc.dao.impl;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.dao.CartDao;
import com.websystique.springmvc.model.Cart;
import com.websystique.springmvc.service.CustomerOrderService;

/**
 * Created by pchapman on 1/25/2017.
 */

@Repository
@Transactional
public class CartDaoImpl extends AbstractDao<Integer, Cart> implements CartDao{

    @Autowired
    private CustomerOrderService customerOrderService;

    public Cart getCartById (int cartId) {
        Cart cart = getByKey(cartId);
        return cart;
    }

    public void update(Cart cart) {
        int cartId = cart.getCartId();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);

        update(cart);
    }

    public Cart validate(int cartId) throws IOException {
        Cart cart=getCartById(cartId);
        if(cart==null||cart.getCartItems().size()==0) {
            throw new IOException(cartId+"");
        }
        update(cart);
        return cart;
    }
 }
