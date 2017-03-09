package com.emusicstore.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.dao.CartItemDao;
import com.websystique.springmvc.model.Cart;
import com.websystique.springmvc.model.CartItem;

/**
 * Created by pchapman on 1/25/2017.
 */

@Repository
@Transactional
public class CartItemDaoImpl extends AbstractDao<Integer, CartItem> implements CartItemDao{

    public void addCartItem(CartItem cartItem) {
        saveOrUpdate(cartItem);
    }

    public void removeCartItem (CartItem cartItem) {
        delete(cartItem);
    }

    public void removeAllCartItems(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems) {
            removeCartItem(item);
        }
    }

    public CartItem getCartItemByProductId (int productId) {
    	Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("productId", productId));

        return (CartItem)crit.uniqueResult();
    }
}
