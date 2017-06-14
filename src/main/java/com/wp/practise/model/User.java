package com.wp.practise.model;

import com.wp.practise.framework.cursor.HasCursor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 用户实体类
 * Created by Wang Peng on 2017/6/7.
 */
public class User implements HasCursor<Integer> {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String userName;

    private String password;

    private Double balance;

    public User(){

    }

    public User(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
