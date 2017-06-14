package com.test;

import com.wp.practise.model.User;
import com.wp.practise.service.UserService;
import com.wp.practise.util.logger.InvestLogger;
import com.wp.practise.util.logger.InvestLoggerFactory;
import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/6/4.
 */
public class Test extends TestCase{

    private InvestLogger logger = InvestLoggerFactory.getLogger(Test.class);

    @Resource
    private UserService userService;

    @org.junit.Test
    public void test1(){
        User user = userService.selectUser(new User("wangpeng", "wangpeng"));
        logger.info("userName",user.getUserName());
    }

}
