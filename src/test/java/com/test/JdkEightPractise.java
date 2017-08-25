package com.test;

import com.google.common.collect.Lists;
import com.wp.practise.model.User;
import javafx.scene.input.DataFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by Wangpeng on 2017/8/17.
 */
public class JdkEightPractise {

    //函数式接口
    @FunctionalInterface
    interface P<T>{
        boolean test(T t);
    }

    //断言型
    public static boolean doPredicate(int age, Predicate<Integer> predicate){
        return predicate.test(age);
    }

    //消费型
    public static void doConsumer(Integer integer, Consumer<Integer> consumer){
        consumer.accept(integer);
    }

    //供给型
    public static List<Integer> supply(Integer integer, Supplier<Integer> supplier){
        List<Integer> integers = Lists.newArrayList();
        for(int x = 0; x < integer; x++)
            integers.add(supplier.get());
        /*integers.forEach(i -> {
            integers.add(supplier.get());
        });*/
        return integers;
    }

    public static void main(String[] args) {

        /**
         * jdk 1.8 新的日期API列举几个 安利了一波
         * update 2017.7.26
         */
        /*System.out.println(LocalDate.now());//返回当前日期格式（yyyy-MM-dd）

        LocalDate.of(2017, 07, 26);

        System.out.println(LocalDate.parse("2017-02-26"));

        System.out.println(LocalDate.now().minus(1, ChronoUnit.MONTHS));//上个月

        System.out.println(LocalDate.now().plus(1, ChronoUnit.DAYS));//明天

        System.out.println(LocalDate.now().getDayOfWeek());//获取星期几

        System.out.println("是否闰年" + LocalDate.now().isLeapYear());

        User user = new User();

        String s = Optional
                .ofNullable(user)
                .map(User::getUserName)
                .orElse("");
        System.out.println(s.indexOf(1));

        Stream.of(1,null,23,4)
                .filter(Objects::nonNull)
                .forEach(System.out::println);*/

        /*DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(LocalDate.parse("2017-8-22 17:05:25", dateTimeFormatter));*/

        Runnable r = () -> {
            System.out.println("");
        };

        System.out.println(doPredicate(17, x -> x >= 18));

        doConsumer(100, m -> {
            System.out.println();
        });

        List<Integer> supply = supply(10, () -> (int) (Math.random() * 100));
        supply.forEach(System.out::println);

        List<Integer> integers = Arrays.asList(22, 23, 4, 34, 54, 50);
        integers.sort(Comparator.naturalOrder());
        System.out.println(integers);

        Integer integer = integers.stream()
                .sorted(Comparator.comparingInt(x -> x))
                .findFirst()
                .get();
        long count = integers.stream()
                .filter(i -> i > 30)
                .count();
        System.out.println(integer);
        System.out.println(count);
    }

}
