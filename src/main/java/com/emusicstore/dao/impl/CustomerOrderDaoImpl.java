package com.emusicstore.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.dao.CustomerOrderDao;
import com.websystique.springmvc.model.CustomerOrder;

/**
 * Created by Le on 1/25/2016.
 */

@Repository
@Transactional
public class CustomerOrderDaoImpl extends AbstractDao<Integer, CustomerOrder> implements CustomerOrderDao{

        public void addCustomerOrder(CustomerOrder customerOrder) {
        	saveOrUpdate(customerOrder);
            getSession().flush();
        }
}
