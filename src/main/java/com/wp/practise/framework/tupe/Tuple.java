package com.wp.practise.framework.tupe;

/**
 * Created by Wang Peng on 2017/6/15.
 */
public class Tuple {

    public static <A,B> TwoTuple<A,B> tuple(final A a,final B b){
        return new TwoTuple<A, B>(a,b);
    }

    public static <A, B, C> ThreeTuple<A, B, C>tuple(final A a, final B b, final C c){
        return new ThreeTuple<A, B, C>(a, b, c);
    }

    public static <A, B, C, D> FourTuple<A, B, C, D> tuple(final A a, final B b, final C c,
                                                           final D d) {
        return new FourTuple<A, B, C, D>(a, b, c, d);
    }

    private Tuple() {
        throw new UnsupportedOperationException();
    }

}
