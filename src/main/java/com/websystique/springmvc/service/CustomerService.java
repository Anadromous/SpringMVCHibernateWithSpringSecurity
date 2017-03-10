package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Customer;


public interface CustomerService {
	
    Customer addCustomer (Customer customer);

    Customer getCustomerById (int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername (String username);

}
