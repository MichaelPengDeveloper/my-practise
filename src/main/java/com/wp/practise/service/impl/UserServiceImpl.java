package com.wp.practise.service.impl;

import com.wp.practise.dao.UserDao;
import com.wp.practise.model.User;
import com.wp.practise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Wang Peng on 2017/6/8.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

   @Override
    public User selectUser(User user) {
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("userName",user.getUserName())
                .andEqualTo("password",user.getPassword());
       List<User> users = userDao.selectByExample(example);
       if (users != null){
           return users.get(0);
       }
       return null;
    }
}
