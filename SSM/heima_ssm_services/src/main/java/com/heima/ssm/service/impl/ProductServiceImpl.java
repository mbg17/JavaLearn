package com.heima.ssm.service.impl;

import com.heima.ssm.dao.ProductDao;
import com.heima.ssm.domain.Product;
import com.heima.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;


    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    @Override
    public Product findById(String id) throws Exception{
        return productDao.findById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void updateProduct(Product product) throws Exception {
        productDao.updateProduct(product);
    }
}
