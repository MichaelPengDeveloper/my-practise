package com.wp.practise.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * Created by Wang Peng on 2017/6/15.
 */
@SuppressWarnings("unused")
public abstract class RequestContextUtils extends RequestContextHolder {

    private static Logger logger = LoggerFactory.getLogger(RequestContextUtils.class);

    private static final String USER_ID = "__CURRENT_LOGINED_USERID__";

    public static void setUserId(int userId){
        currentRequestAttributes().setAttribute(USER_ID,userId, RequestAttributes.SCOPE_REQUEST);
    }

    public static Integer getUserId(){
        return (Integer)currentRequestAttributes().getAttribute(USER_ID,RequestAttributes.SCOPE_REQUEST);
    }

}
