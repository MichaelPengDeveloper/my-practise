package com.wp.practise.util.logger;

/**
 * Created by Vincent Wang on 2017/2/13.
 */
public class InvestLoggerFactory {

    public static InvestLogger getLogger(Class<?> clazz) {
        return new InvestLogger(clazz);
    }

    public static InvestLogger getLogger(String name) {
        return new InvestLogger(name);
    }
}
