package com.websystique.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.websystique.springmvc.model.Cart;
import com.websystique.springmvc.model.CartItem;
import com.websystique.springmvc.model.Customer;
import com.websystique.springmvc.service.CartItemService;
import com.websystique.springmvc.service.CartService;
import com.websystique.springmvc.service.CustomerService;


/**
 * Created by pchapman on 1/25/2017.
 */

@Controller
@RequestMapping("/customer/cart")
public class CartController {

	static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private CartService cartService;
    
    @Autowired
    private CartItemService cartItemService;

    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser){
    	logger.info("CustomerService.getCart.......");
        Customer customer = customerService.getCustomerByUsername (activeUser.getUsername());
        int cartId = customer.getCart().getCartId();
        logger.info("Cart: "+cartId +", Customer: " +customer.getLastName());
        return "redirect:/customer/cart/"+cartId;
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable (value = "cartId") int cartId, Model model) {
    	logger.info("CustomerService.getCartRedirect......."+cartId);
        //model.addAttribute("cartId", cartId);
    	Cart cart = cartService.getCartById(cartId);
    	model.addAttribute("grandTotal", cart.getGrandTotal());
    	model.addAttribute("cartItems", cart.getCartItems());
        return "cart";
    }
    
    @RequestMapping(value = "/remove/{cartItemId}")
    public String removeItem (@PathVariable(value = "cartItemId") int cartItemId) {
    	logger.info("CartResources.removeItem..."+cartItemId);
    	CartItem cartItem = cartItemService.getCartItemById(cartItemId);
    	logger.info("Here is the cartItem: "+cartItem.toString());
        cartItemService.removeCartItem(cartItem);
        return "redirect:/customer/cart/"+cartItem.getCart().getCartId();
    }

    @RequestMapping(value = "/empty/{cartId}")
    public String clearCart(@PathVariable(value = "cartId") int cartId) {
    	logger.info("CartResources.clearCart...");
        Cart cart = cartService.getCartById(cartId);
        cartItemService.removeAllCartItems(cart);
        return "redirect:/customer/cart/"+cartId;
    }
}

