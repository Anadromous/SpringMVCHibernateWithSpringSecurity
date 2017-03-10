package com.websystique.springmvc.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.CustomerOrderDao;
import com.websystique.springmvc.model.CustomerOrder;

/**
 * Created by pchapman on 1/25/2017.
 */

@Repository("customerOrderDao")
public class CustomerOrderDaoImpl implements CustomerOrderDao{

        @Autowired
        private SessionFactory sessionFactory;

        public void addCustomerOrder(CustomerOrder customerOrder) {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(customerOrder);
            session.flush();
        }
}
