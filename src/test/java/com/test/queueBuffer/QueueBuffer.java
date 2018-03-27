package com.test.queueBuffer;

/**
 * Created by Wangpeng on 2018/3/27.
 */
public class QueueBuffer {

    int n;
    boolean valueSet = false;

    synchronized int get() {
        if (!valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        if (valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }


    public static void main(String[] args) {
        QueueBuffer queueBuffer = new QueueBuffer();
        new Consumer(queueBuffer);
        new Producer(queueBuffer);
        System.out.println("Press Control-C to stop.");
    }

}
