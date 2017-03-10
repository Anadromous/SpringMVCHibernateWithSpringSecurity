package com.websystique.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.CustomerOrderDao;
import com.websystique.springmvc.model.Cart;
import com.websystique.springmvc.model.CartItem;
import com.websystique.springmvc.model.CustomerOrder;
import com.websystique.springmvc.service.CartService;
import com.websystique.springmvc.service.CustomerOrderService;

/**
 * Created by pchapman on 1/25/2017.
 */

@Service("customerOrderService")
@Transactional
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal(int cartId) {
        double grandTotal=0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems) {
            grandTotal+=item.getTotalPrice();
        }

        return grandTotal;
    }
}
