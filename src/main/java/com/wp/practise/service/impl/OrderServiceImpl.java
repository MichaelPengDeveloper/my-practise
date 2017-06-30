package com.wp.practise.service.impl;

import com.wp.practise.dao.OrderDao;
import com.wp.practise.dao.ProductDao;
import com.wp.practise.dao.UserDao;
import com.wp.practise.framework.util.RequestContextUtils;
import com.wp.practise.model.Order;
import com.wp.practise.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

/**
 * Created by Wang Peng on 2017/6/15.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public int insertOrder(Order order) {
        return orderDao.insertSelective(order);
    }

    public void test(){

    }

}
