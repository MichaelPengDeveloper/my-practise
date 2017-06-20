package com.wp.practise.controller;

import com.wp.practise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wang Peng on 2017/6/15.
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

}
