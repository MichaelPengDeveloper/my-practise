package com.test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.primitives.Ints;
import com.test.designPatterns.singleton.Singleton;
import com.wp.practise.framework.cursor.CursorUtils;
import com.wp.practise.model.Order;
import com.wp.practise.model.User;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/6/4.
 */
public class Test {

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

       /* System.out.println(0x7fffffff);
        System.out.println(Integer.MAX_VALUE - 8);*/
       /* Objects.requireNonNull(null);
        System.out.println();*/
        List<String> mod = new ArrayList<String>();
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


        /**/
        //long l = System.currentTimeMillis();
        /*while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/

        /*for (String s : mod){
            System.out.println(s);
        }*/

        //iterator.forEachRemaining(o ->{System.out.println(o);});
       /* long l1 = System.currentTimeMillis();

        System.out.println(l1 - l);

        System.out.println(9 >> 1);*/
//        String cursor = CursorUtils.getCursor(Order.class, 1);


        //int test = (elementData != EMPTY_ELEMENTDATA) ? 0 : DEFAULT_CAPACITY;

        Map<String, Object> map = new HashMap<>();
        map.put("a", "c");
        map.put("b", "b");
        Map<String, Object> map1 = new HashMap<>();
        map.put("a", "c");
        map.put("b", "b");
        map.put("c", "a");
        List<Map<String, Object>> maps = new ArrayList<>();
        maps.add(map);
        maps.add(map1);

        Set<String> strings = new HashSet<>();
        maps.stream()
                .forEach(f ->{
                    for (String key : f.keySet()) {
                        strings.add(key);
                    }
                });

        strings.stream()
                .forEach(l -> {
                    System.out.println(l);
                });

        System.out.println(map.get("sd"));

    }

    static class MapKeyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

}
