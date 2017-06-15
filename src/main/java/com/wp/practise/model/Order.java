package com.wp.practise.model;

import com.wp.practise.framework.cursor.HasCursor;

import java.util.Date;

/**
 * Created by Wang Peng on 2017/6/15.
 */
public class Order implements HasCursor<Integer> {

    private Integer id;

    private String orderNumber;

    private Integer userId;

    private Integer productId;

    private Date createTime;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
