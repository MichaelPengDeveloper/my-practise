package com.wp.practise.framework.interceptors;

import com.wp.practise.framework.annotations.Test;
import com.wp.practise.framework.meta.Meta;
import com.wp.practise.framework.util.MethodInterceptorUtils;
import com.wp.practise.framework.util.ResponseUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created by Wangpeng on 2017/7/27.
 */
public class TestAnnotation extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Test annotation = MethodInterceptorUtils.getAnnotation(handler, Test.class);

        if (Objects.nonNull(annotation))
            return true;

        ResponseUtils.output(response, Meta.MetaCode.Fail.withMessage("测试成功！"));

        return true;

    }
}
