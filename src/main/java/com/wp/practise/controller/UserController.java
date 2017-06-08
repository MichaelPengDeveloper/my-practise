package com.wp.practise.controller;

import com.wp.practise.model.User;
import com.wp.practise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wang Peng on 2017/6/7.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String jumpIndex(@RequestParam(defaultValue = "",required = false)String userName,
                            @RequestParam(defaultValue = "",required = false)String password){
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        User user1 = userService.selectUser(user);
        System.out.println(user1);
        return "/index";
    }

}
