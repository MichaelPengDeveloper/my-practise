package com.test;

/**
 * 一个静态代理类的练习 http://xiezhaodong.me
 * Created by Wang Peng on 2017/6/6.
 */
public interface Calculator {

    public int add(int a, int b);

    public static class CalculatorImpl implements Calculator{

        public int add(int a, int b) {
            System.out.println("doing :");
            return a+b;
        }
    }

    public static class CalculatorProxy implements Calculator{

        private Calculator calculator;

        public CalculatorProxy(Calculator calculator){
            this.calculator = calculator;
        }

        public int add(int a, int b) {

            System.out.println("start : ");

            int i = a + b;

            System.out.println("end");

            return i;
        }
    }

}
