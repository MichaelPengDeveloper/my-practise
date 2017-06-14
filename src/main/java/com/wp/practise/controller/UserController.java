package com.wp.practise.controller;

import com.wp.practise.framework.view.ViewBuilder;
import com.wp.practise.model.User;
import com.wp.practise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wang Peng on 2017/6/7.
 */
@RestController
public class UserController {

    @Autowired
    private ViewBuilder viewBuilder;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public Object jumpIndex(@RequestParam(defaultValue = "",required = false)String userName,
                            @RequestParam(defaultValue = "",required = false)String password){
        User user = userService.selectUser(new User(userName, password));
        return viewBuilder.buildSingle(user,"user");
    }

}
