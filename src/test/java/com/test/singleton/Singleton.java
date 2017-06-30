package com.test.singleton;

/**
 * 几个单利模式的创建方式
 *
 * Created by Wang peng on 2017/6/30.
 */
public class Singleton {

    private static final SingletonMayExtends<Singleton> in = new SingletonMayExtends<Singleton>() {
        @Override
        protected Singleton create() {
            return new Singleton();
        }
    };

    public static Singleton getSingletonCheck (){
        return in.get();
    }

    private static Singleton singletonLazy = new Singleton();

    private static Singleton singletonHungry;

    private static Singleton singletonDcl;

    private Singleton(){

    }

    //饿汉式
    public static Singleton getInstanceHungry(){
        return singletonLazy;
    }

    //懒汉式
    public static synchronized Singleton getInstanceLazy(){

        if (singletonHungry == null){
            singletonHungry = new Singleton();
        }
        return singletonHungry;
    }

    //双重加锁
    public static Singleton getSingletonDcl(){

        if (singletonDcl == null){
            synchronized (Singleton.class){
                if (singletonDcl == null){
                    return singletonDcl = new Singleton();
                }
            }
        }
        return singletonDcl;
    }

    //静态内部类
    private static class InnerSingleton{

        private static final Singleton singletonInner = new Singleton();

    }

    public static final Singleton getSingletonInner(){
        return InnerSingleton.singletonInner;
    }

}
