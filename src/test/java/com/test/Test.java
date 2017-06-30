package com.test;

import com.wp.practise.model.User;
import com.wp.practise.service.OrderService;
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
public class Test{

    public static void main(String[] args){

        Integer i1 = new Integer(130);
        Integer i2 = new Integer(130);
        System.out.println(i1 == i2);
    }

}
