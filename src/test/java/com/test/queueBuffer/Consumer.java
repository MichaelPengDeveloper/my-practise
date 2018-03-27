package com.test.queueBuffer;

/**
 * Created by Wangpeng on 2018/3/27.
 */
public class Consumer implements Runnable{

        private QueueBuffer q;

        Consumer(QueueBuffer q) {
            this.q = q;
            new Thread(this, "Consumer").start();
        }

        public void run() {
            while (true) {
                q.get();
            }
        }

}
