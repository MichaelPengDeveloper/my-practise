package com.wp.practise.service;

import com.wp.practise.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Wang Peng on 2017/6/8.
 */
public interface UserService {

    User selectUser(User user);

}
