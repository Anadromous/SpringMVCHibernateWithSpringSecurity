package com.websystique.springmvc.dao.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.dao.CartDao;
import com.websystique.springmvc.model.Cart;
import com.websystique.springmvc.service.CustomerOrderService;

/**
 * Created by pchapman on 1/25/2017.
 */

@Repository("cartDao")
public class CartDaoImpl extends AbstractDao<Integer, Cart> implements CartDao{
	
	static final Logger logger = LoggerFactory.getLogger(CartDaoImpl.class);

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
        logger.info("Updating cart: "+cart.toString());
        saveOrUpdate(cart);
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
