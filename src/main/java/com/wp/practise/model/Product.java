package com.wp.practise.model;

import com.wp.practise.framework.cursor.HasCursor;
import org.springframework.security.access.method.P;

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

    private Double price;

    public Product(Integer id){
        this.id = id;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
