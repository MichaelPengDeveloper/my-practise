package com.test.limitStream;

/**
 * 在简书上读了篇面临高并发请求的应对措施，其中有项方案就是限流，而限流的几个主要方法为（计数器、滑动窗口、漏桶）
 * 下面就是大概的计数器限流方法
 *
 * Created by Wangpeng on 2017/8/17.
 */
public class CounterDemo {

    private static long timeStamp = System.currentTimeMillis();

    private static long reqCount = 0;

    private static long limitCount = 100;

    private static long interval = 1000;

    public static boolean grant (){
        long now = System.currentTimeMillis();
        if (now < timeStamp + interval){
            if (reqCount < limitCount){
                ++reqCount;
                return true;
            }else {
                return false;
            }

        }else {
            timeStamp = System.currentTimeMillis();
            reqCount = 0;
            return false;
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 500; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (grant())
                        System.out.println("执行业务逻辑");
                    else
                        System.out.println("限流" );
                }
            }).start();
        }

    }

}
