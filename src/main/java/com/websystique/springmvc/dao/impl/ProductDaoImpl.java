package com.websystique.springmvc.dao.impl;


import java.util.List;

import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.dao.ProductDao;
import com.websystique.springmvc.model.Product;

/**
 * Created by pchapman on 1/6/2016.
 */

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {

	static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);
	
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
        saveOrUpdate(product);
    }

    public void deleteProduct (Product product) {
        delete(product);
    }
}
