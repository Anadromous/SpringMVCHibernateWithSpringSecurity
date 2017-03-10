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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int customerId;
    
    @NotEmpty
	@Column(name="first_name", nullable=false)
	private String firstName;

	@NotEmpty
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@NotEmpty
	@Column(name="SSO_ID", unique=true, nullable=false)
	private String ssoId;

    @NotEmpty (message = "The customer email must not be null.")
    @Column(name="email")
    private String customerEmail;
    
    @Column(name="phone")
    private String customerPhone;

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

	public String getSsoId() {
		return ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerEmail == null) ? 0 : customerEmail.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((customerPhone == null) ? 0 : customerPhone.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Customer))
			return false;
		Customer other = (Customer) obj;
		if (customerEmail == null) {
			if (other.customerEmail != null)
				return false;
		} else if (!customerEmail.equals(other.customerEmail))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerPhone == null) {
			if (other.customerPhone != null)
				return false;
		} else if (!customerPhone.equals(other.customerPhone))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", SSOID=" + ssoId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", customerEmail=" + customerEmail + ", customerPhone=" + customerPhone + "]";
	}
    
}

