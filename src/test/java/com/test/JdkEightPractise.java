package com.test;

import com.wp.practise.model.User;
import javafx.scene.input.DataFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Wangpeng on 2017/8/17.
 */
public class JdkEightPractise {

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

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(LocalDate.parse("2017-8-22 17:05:25", dateTimeFormatter));

    }

}
