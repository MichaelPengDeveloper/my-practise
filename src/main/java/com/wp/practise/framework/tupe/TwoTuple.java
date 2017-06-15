package com.wp.practise.framework.tupe;

/**
 * Created by Wang Peng on 2017/6/15.
 */
public class TwoTuple<A,B> {

    public final A first;

    public final B second;

    public A getFirst(){
        return first;
    }

    public B getSecond(){
        return second;
    }

    public TwoTuple(final A a,final B b){
        this.first = a;
        this.second = b;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TwoTuple<?, ?> twoTuple = (TwoTuple<?, ?>) o;

        if (!first.equals(twoTuple.first)) return false;
        return second.equals(twoTuple.second);
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + second.hashCode();
        return result;
    }
}
