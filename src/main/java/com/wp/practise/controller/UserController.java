package com.wp.practise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wang Peng on 2017/6/7.
 */
@Controller
public class UserController {

    @RequestMapping(value = "/index")
    public String jumpIndex(){
        return "/index";
    }

}
