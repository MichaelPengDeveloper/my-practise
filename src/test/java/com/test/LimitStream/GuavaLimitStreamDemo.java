package com.test.LimitStream;

import com.google.common.util.concurrent.RateLimiter;
import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 不得不说Guava是个神奇的类库，里面也有基于令牌桶限流方法实现限流的方式，再次安利，希望之火能用到
 *
 * Created by Wangpeng on 2017/8/17.
 */
public class GuavaLimitStreamDemo {

    public static ConcurrentHashMap<String, RateLimiter> limiterConcurrentHashMap = new ConcurrentHashMap<>();

    static {
        createResourceLimiter("order", 100);
    }

    public static void createResourceLimiter(String resource, double qps){

        if (limiterConcurrentHashMap.contains(resource)){
            limiterConcurrentHashMap.get(resource).setRate(qps);
        }else {
            RateLimiter rateLimiter = RateLimiter.create(qps);
            limiterConcurrentHashMap.put(resource, rateLimiter);
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 5000; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (limiterConcurrentHashMap.get("order").tryAcquire(1, TimeUnit.MILLISECONDS)){
                        System.out.println("执行业务逻辑");
                    } else
                        System.out.println("限流");
                }
            }).start();
        }
    }

}
