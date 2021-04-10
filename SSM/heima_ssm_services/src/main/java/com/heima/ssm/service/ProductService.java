package com.heima.ssm.service;

import com.heima.ssm.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;

    Product findById(String id) throws Exception;

    void updateProduct(Product product) throws Exception;
}
