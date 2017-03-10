package com.websystique.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.dao.CustomerDao;
import com.websystique.springmvc.model.Cart;
import com.websystique.springmvc.model.Customer;
import com.websystique.springmvc.model.User;

/**
 * Created by pchapman on 1/25/2017.
 */

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao{

    public Customer addCustomer(Customer customer) {

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        saveOrUpdate(customer);
        getSession().saveOrUpdate(customer.getBillingAddress());
        getSession().saveOrUpdate(customer.getShippingAddress());

        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);
        saveOrUpdate(customer);
        getSession().saveOrUpdate(newCart);
        getSession().flush();
        
        return getCustomerByUsername(customer.getSsoId());
        
    }

    public Customer getCustomerById (int customerId) {
        return (Customer) getByKey(customerId);
    }

    public List<Customer> getAllCustomers() {
    	Criteria crit = createEntityCriteria();
        List<Customer> customerList = crit.list();
        return customerList;
    }

    public Customer getCustomerByUsername (String username) {
    	Criteria crit = createEntityCriteria();
    	crit.add(Restrictions.eq("ssoId", username));
        return (Customer) crit.uniqueResult();
    }
}
