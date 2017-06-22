package com.wp.practise.controller;

import com.wp.practise.framework.cursor.CursorUtils;
import com.wp.practise.framework.exception.AesDecodeException;
import com.wp.practise.framework.meta.Meta;
import com.wp.practise.framework.view.ViewBuilder;
import com.wp.practise.model.Product;
import com.wp.practise.service.ProductService;
import com.wp.practise.util.logger.InvestLogger;
import com.wp.practise.util.logger.InvestLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wang Peng on 2017/6/15.
 */
@RestController
public class ProductController {

    private InvestLogger logger = InvestLoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private ViewBuilder viewBuilder;

    @RequestMapping(value = "/productInfo")
    public Object selectProductInfo(@RequestParam(value = "cursor") String cursor){

        int id;

        try {
             id = CursorUtils.getId(Product.class,cursor).intValue();
        } catch (AesDecodeException e) {
            return Meta.MetaCode.Fail.withMessage("该商品Id不存在");
        }
        return viewBuilder.buildSingle(productService.selectOneProduct(new Product(id)),"productInfo");
    }

}
