package com.websystique.springmvc.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Product;
import com.websystique.springmvc.model.UserProfile;

/**
 * Created by pchapman on 1/6/2016.
 */

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {

	static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);
	
    @Autowired
    private SessionFactory sessionFactory;

    public Product getProductById (int id) {
        Product product = getByKey(id);
        return product;
    }

    public List<Product> getProductList() {
    	logger.info("getProductList()...");
        
    	Criteria crit = createEntityCriteria();
		//crit.addOrder(Order.asc("type"));
		return (List<Product>)crit.list();
    }

    public void addProduct (Product product) {
        persist(product);
    }

    public void editProduct (Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void deleteProduct (Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }
}
