package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Product;

/**
 * Created by pchapman on 1/24/2016.
 */

public interface ProductService {

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}
