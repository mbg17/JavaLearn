package com.heima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.heima.ssm.dao.OrdersDao;
import com.heima.ssm.domain.Orders;
import com.heima.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;
    @Override
    public List<Orders> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String id) throws Exception {
        return ordersDao.findById(id);
    }
}
