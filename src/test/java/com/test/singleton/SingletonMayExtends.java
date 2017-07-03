package com.test.singleton;

/**
 * 登记式单例模式
 *
 * Created by Wang peng on 2017/6/30.
 */
public abstract class SingletonMayExtends<T> {

    private T instance;

    protected abstract T create();

    public final T get(){
        synchronized (this){
            if (instance == null){
                instance = create();
            }
            return instance;
        }
    }

}
