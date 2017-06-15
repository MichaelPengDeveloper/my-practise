package com.wp.practise.service.impl;

import com.wp.practise.dao.UserDao;
import com.wp.practise.framework.encrypt.AES;
import com.wp.practise.framework.tupe.Tuple;
import com.wp.practise.framework.tupe.TwoTuple;
import com.wp.practise.framework.util.RequestContextUtils;
import com.wp.practise.model.User;
import com.wp.practise.service.UserService;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Wang Peng on 2017/6/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    public TwoTuple<User,Boolean> login(String userName, String password, HttpServletRequest request) {

        User user = userDao.selectOne(new User(userName, password));

        if (user != null){
            HttpSession session = request.getSession();
            session.setAttribute("userInfo",user);
            RequestContextUtils.setUserId(user.getId());
        }else {
            return Tuple.tuple(user,false);
        }

        return Tuple.tuple(user,true);
    }

}
