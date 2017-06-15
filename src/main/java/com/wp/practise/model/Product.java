package com.wp.practise.model;

import com.wp.practise.framework.cursor.HasCursor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Wang Peng on 2017/6/15.
 */
public class Product implements HasCursor<Integer> {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String productName;

    private Integer number;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
