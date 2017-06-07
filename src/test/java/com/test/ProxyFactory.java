package com.test;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 一个动态代理类 转自alibaba http://xiezhaodong.me
 * Created by Wang Peng on 2017/6/6.
 */
public class ProxyFactory implements InvocationHandler {

    private Class<?> target;
    private Object real;

    //委托类class
    public ProxyFactory(Class<?> target){
        this.target = target;
    }

    //实际执行class
    public Object bind(Object real){
        this.real = real;
        //利用jdk实现动态代理
        return Proxy.newProxyInstance(target.getClassLoader(),new Class[]{target},this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin");
        Object invoke = method.invoke(real, args);
        System.out.println("end");
        return invoke;
    }

    public static void main(String[] args){
        /*Calculator bind = (Calculator) new ProxyFactory(Calculator.class).bind(new Calculator.CalculatorImpl());
        bind.add(1,2);*/
        try {
            generateClassFile(Calculator.class,"Calcultor$ProxyCode");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateClassFile(Class clazz,String proxyName) throws IOException {
        byte[] bytes = ProxyGenerator.generateProxyClass(proxyName, new Class[]{clazz});

        String path = clazz.getResource(".").getPath();

        System.out.println(path);

        FileOutputStream fileOutputStream = null;

        fileOutputStream = new FileOutputStream(path + proxyName + ".class");

        fileOutputStream.write(bytes);

        fileOutputStream.flush();

    }

}
