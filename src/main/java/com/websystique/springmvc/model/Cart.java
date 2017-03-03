package com.websystique.springmvc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by pchapman on 1/11/2016.
 */

@Entity(name="CART")
public class Cart implements Serializable {

    private static final long serialVersionUID = 3940548625296145582L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;
    
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;
    
    @OneToOne
    @JoinColumn(name = "SSO_ID")
    @JsonIgnore
    private User user;
    
    @Column(name="grand_total")
    private double grandTotal;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
}

