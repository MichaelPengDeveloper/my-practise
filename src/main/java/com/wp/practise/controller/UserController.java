package com.wp.practise.controller;

import com.wp.practise.framework.meta.Meta;
import com.wp.practise.framework.tupe.TwoTuple;
import com.wp.practise.framework.view.ViewBuilder;
import com.wp.practise.model.User;
import com.wp.practise.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
                            @RequestParam(defaultValue = "",required = false)String password, HttpServletRequest request){

        if (StringUtils.isBlank(userName)){
            return Meta.MetaCode.Fail.withMessage("用户名不能为空！");
        }

        if (StringUtils.isBlank(password)){
            return Meta.MetaCode.Fail.withMessage("密码不能为空");
        }

        TwoTuple<User, Boolean> login = userService.login(userName, password, request);

        if (!login.getSecond()){
            return Meta.MetaCode.Unauthorized.getMessage();
        }

        return viewBuilder.buildSingle(login.getFirst(),"userInfo");
    }

}
