package com.wp.practise.util.logger;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * 简单封装的日志类
 *
 * Created by Vincent Wang on 2017/2/13.
 */
public class InvestLogger {

    private Logger logger;

    public InvestLogger(Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    public InvestLogger(String name) {
        logger = LoggerFactory.getLogger(name);
    }

    private void log(boolean methodSuccess, Consumer<String> consumer) {
        StringBuilder prefix = new StringBuilder(128);
        try {
            StackTraceElement[] elements = Thread.currentThread().getStackTrace();
            boolean found = false;
            String className;
            String loggerClassName;
            for (StackTraceElement element : elements) {
                className = element.getClassName();
                loggerClassName = getClass().getName();
                if (!className.equals(loggerClassName) && !className.equals("java.lang.Thread")) {
                    prefix.append(element.getClassName())
                            .append(".")
                            .append(element.getMethodName())
                            .append("^|");
                    found = true;
                    break;
                }
            }
            if (!found) {
                prefix.append("unknownMethod^|");
            }
        } catch (Exception e) {
            prefix.append("unknownMethod^|");
            logger.error("Ops. {}", e);
        }
        /*prefix.append(RequestContext.getCurrentIpInString())
                .append("^|")
                .append((methodSuccess ? "Y^|" : "N^|"))
                .append((System.currentTimeMillis() - RequestContext.getRequestTimeStamp()))
                .append("^|");*/
        consumer.accept(prefix.toString());
    }

    public void info(boolean methodSuccess, String var1, Object... var2) {
        this.log(methodSuccess, x -> logger.info(x + var1, var2));
    }

    public void info(String var1, Object... var2) {
        this.info(true, var1, var2);
    }

    public void warn(boolean methodSuccess, String var1, Object... var2) {
        if (ArrayUtils.isEmpty(var2)) {
            this.log(methodSuccess, x -> logger.warn(x + var1));
        }
        else {
            Object[] arr = Arrays.stream(var2)
                    .map(v -> v instanceof Throwable ? ExceptionUtils.getStackTrace((Throwable) v) : v)
                    .toArray();
            this.log(methodSuccess, x -> logger.warn(x + var1, arr));
        }
    }

    public void warn(String var1, Object... var2) {
        this.warn(true, var1, var2);
    }

    public void error(boolean methodSuccess, String var1, Object... var2) {
        if (ArrayUtils.isEmpty(var2)) {
            this.log(methodSuccess, x -> logger.error(x + var1));
        } else {
            Object[] arr = Arrays.stream(var2)
                    .map(v -> v instanceof Throwable ? ExceptionUtils.getStackTrace((Throwable) v) : v)
                    .toArray();
            this.log(methodSuccess, x -> logger.error(x + var1, arr));
        }
    }

    public void error(String var1, Object... var2) {
        this.error(true, var1, var2);
    }

    public void trace(String var1, Object... var2) {
        this.log(true, x -> logger.trace(x + var1, var2));
    }

    public void debug(String var1, Object... var2) {
        this.log(true, x -> logger.debug(x + var1, var2));
    }

}
