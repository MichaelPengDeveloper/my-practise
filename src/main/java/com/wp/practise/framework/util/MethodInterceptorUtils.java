package com.wp.practise.framework.util;

import com.wp.practise.util.logger.InvestLogger;
import com.wp.practise.util.logger.InvestLoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;

import java.lang.annotation.Annotation;
import java.util.Objects;

/**
 * Created by Wangpeng on 2017/7/27.
 */
public class MethodInterceptorUtils {

    private static InvestLogger logger = InvestLoggerFactory.getLogger(MethodInterceptorUtils.class);

    public static <A extends Annotation> A getAnnotation(Object handler, Class<A> annotationsClass){
        if ((handler instanceof HandlerMethod))
            return null;
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        A result;

        if (Objects.nonNull((result = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), annotationsClass))))
            logger.trace("found [{}] annotation in method-level:{}",
                    annotationsClass.getSimpleName(), handlerMethod.getMethod());
        else
            if (Objects.nonNull((result = AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), annotationsClass))))
                logger.trace("found [{}] annotation in type-level:{}",
                        annotationsClass.getSimpleName(), handlerMethod.getBeanType());
        return result;
    }

}
