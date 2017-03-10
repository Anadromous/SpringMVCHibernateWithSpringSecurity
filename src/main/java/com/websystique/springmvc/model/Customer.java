package com.websystique.springmvc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pchapman on 1/24/2017.
 */

@Entity(name="CUSTOMER")
public class Customer implements Serializable{

    private static final long serialVersionUID = 5140900014886997914L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="customer_id")
    private int customerId;
    
    @NotEmpty
	@Column(name="first_name", nullable=false)
	private String firstName;

	@NotEmpty
	@Column(name="last_name", nullable=false)
	private String lastName;

    @NotEmpty (message = "The customer email must not be null.")
    @Column(name="email")
    private String customerEmail;
    private String customerPhone;

    @NotEmpty (message = "The customer username must not be null.")
    @Column(name="user_name")
    private String username;

    @NotEmpty (message = "The customer password must not be null.")
    @Column(name="password")
    private String password;

    @Column(name="enabled")
    private boolean enabled;

    @OneToOne
    @JoinColumn(name="billing_id")
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name="shipping_id")
    private ShippingAddress shippingAddress;

    @OneToOne
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    private Cart cart;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public BillingAddress getBillingAddress() {
    	if(billingAddress == null){
    		billingAddress = new BillingAddress();
    	}
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
    	if(shippingAddress == null){
    		shippingAddress = new ShippingAddress();
    	}
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

	public User getUser() {
		if(user == null){
			user = new User();
		}
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}

