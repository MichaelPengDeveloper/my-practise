package com.test;

import com.test.designPatterns.singleton.Singleton;
import com.wp.practise.framework.cursor.CursorUtils;
import com.wp.practise.model.Order;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/6/4.
 */
public class Test{

    boolean lock;

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    static transient Object[] elementData;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final int DEFAULT_CAPACITY = 10;

    public static void main(String[] args) throws InterruptedException {

        /*final Set<String> strings = Collections.synchronizedSet(new HashSet<String>());

        final Test test = new Test();

        test.setLock(true);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {

                public void run() {
                    while (true) {
                        System.out.println(Thread.currentThread().getName() + "" +!test.isLock());
                        if (!test.isLock()) {
                            Singleton singleton = Singleton.getInstanceLazy();
                            strings.add(singleton.toString());
                            break;
                        }
                    }
                }
            });

        }

        Thread.sleep(500);
        test.setLock(false);
        Thread.sleep(500);
        System.out.println("------并发情况下我们取到的实例------");
        for (String instance : strings) {
            System.out.println(instance);
        }
        executorService.shutdown();*/

        System.out.println(9 >> 1);
        String cursor = CursorUtils.getCursor(Order.class, 1);

        int test = (elementData != EMPTY_ELEMENTDATA) ? 0 : DEFAULT_CAPACITY;

    }

}
