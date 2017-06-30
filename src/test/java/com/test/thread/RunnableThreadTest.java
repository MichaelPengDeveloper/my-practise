package com.test.thread;

/**
 * 第二种创建方式
 *
 * Created by Wang peng on 2017/6/30.
 */
public class RunnableThreadTest implements Runnable {

    @Override
    public void run() {

        for (int i = 0;i<100; i++)
            System.out.println(Thread.currentThread().getName() + "　" + i);

    }

    public static void main(String[] args)
    {
        for(int i = 0;i < 100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==20)
            {
                RunnableThreadTest rtt = new RunnableThreadTest();
                new Thread(rtt,"新线程1").start();
                new Thread(rtt,"新线程2").start();
            }
        }

    }

}
