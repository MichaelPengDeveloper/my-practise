package com.wp.practise.service;

import com.wp.practise.framework.tupe.TwoTuple;
import com.wp.practise.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Wang Peng on 2017/6/8.
 */
public interface UserService {

    TwoTuple<User,Boolean> login(String userName, String password, HttpServletRequest request);

}
