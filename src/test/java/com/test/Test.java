package com.test;

import com.test.designPatterns.singleton.Singleton;
import com.wp.practise.framework.cursor.CursorUtils;
import com.wp.practise.model.Order;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/6/4.
 */
public class Test{

    boolean lock;

    private static final Long A = Long.valueOf(Long.MAX_VALUE);

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

        /*System.out.println(0x7fffffff);
        System.out.println(Integer.MAX_VALUE - 8);
        Objects.requireNonNull(null);
        System.out.println();
        List<String> mod = new ArrayList<>();

        mod.add("1");
        mod.add("23");
        mod.add("12");
        mod.add("1");
        mod.add("23");
        mod.add("12");

        ListIterator<String> stringListIterator = mod.listIterator();

        stringListIterator.set(mod.get(1).replace("1", "2"));

        while (stringListIterator.hasNext()){
            System.out.println(stringListIterator.next());
        }

        Iterator<String> iterator = mod.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println(mod.size());

        System.out.println(9 >> 1);
        String cursor = CursorUtils.getCursor(Order.class, 1);*/

        Integer test1 = Integer.valueOf(300);
        Integer test2 = Integer.valueOf(300);

        Integer test3 = 20;
        Integer test4 = 20;

        System.out.println(test1 == test2);
        System.out.println(test3 == test4);

        //int test = (elementData != EMPTY_ELEMENTDATA) ? 0 : DEFAULT_CAPACITY;

    }

}
