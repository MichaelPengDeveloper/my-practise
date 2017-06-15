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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/4.
 */
public class Test extends TestCase{

    private InvestLogger logger = InvestLoggerFactory.getLogger(Test.class);

    @Resource
    private UserService userService;

    private final List list = new ArrayList();

    @org.junit.Test
    public void test1(){
        String test = new String("1");

        list.add("1");
        test = "1";

    }

    class Childeren extends Father{

    }

    class Father{
        public final String testFinal(){
            return "test children";
        }
    }

}
