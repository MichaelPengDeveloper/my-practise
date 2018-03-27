package com.test.queueBuffer;

/**
 * Created by Wangpeng on 2018/3/27.
 */
public class Producer implements Runnable{
    private QueueBuffer q;

    Producer(QueueBuffer q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }
}
