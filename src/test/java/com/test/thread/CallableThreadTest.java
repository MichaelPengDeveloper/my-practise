package com.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 第三种创建线程方式
 *
 * Created by Wang peng on 2017/6/30.
 */
public class CallableThreadTest implements Callable<Integer> {

    public static void main(String[] args){
        CallableThreadTest callableThreadTest = new CallableThreadTest();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callableThreadTest);

        for(int i = 0;i < 100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值"+i);
            if(i==20) {
                new Thread(futureTask,"有返回值的线程").start();
            }
        }

        try {
            System.out.println("子线程的返回值："+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (;i<100; i++)
            System.out.println(Thread.currentThread().getName() + "　" + i);
        return i;
    }
}
