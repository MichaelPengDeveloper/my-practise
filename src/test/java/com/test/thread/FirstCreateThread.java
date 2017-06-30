package com.test.thread;

/**
 * 第一种创建线程方式
 *
 * Created by Wang peng on 2017/6/30.
 */
public class FirstCreateThread extends Thread{

    public void run(){
        for (int i = 0;i<100; i++)
            System.out.println(getName() + "　" + i);
    }

    public static void main(String[] args)
    {
        for(int i = 0;i< 100;i++)
        {
            System.out.println(Thread.currentThread().getName()+"  : "+i);
            if(i==20)
            {
                new FirstCreateThread().start();
                new FirstCreateThread().start();
            }
        }
    }

}
