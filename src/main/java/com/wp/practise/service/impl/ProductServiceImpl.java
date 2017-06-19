package com.wp.practise.service.impl;

import com.wp.practise.dao.ProductDao;
import com.wp.practise.model.Product;
import com.wp.practise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Wang Peng on 2017/6/15.
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public Product selectOneProduct(Product product) {
        return productDao.selectOne(product);
    }
}
