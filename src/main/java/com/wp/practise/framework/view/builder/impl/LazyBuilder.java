package com.wp.practise.framework.view.builder.impl;


import java.util.Collection;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import com.wp.practise.framework.view.builder.impl.SimpleModelBuilder.Lazy;
/**
 * Created by Wang Peng on 2017/6/14.
 */
public class LazyBuilder {

    public static <K> Lazy on(Object sourceNamespace, Function<Collection<K>, Map<K, ?>> builder,
                                                 Object targetNamespace) {
        return new SimpleModelBuilder.Lazy() {

            @Override
            public Object sourceNamespace() {
                return sourceNamespace;
            }

            @Override
            public Object targetNamespace() {
                return targetNamespace;
            }

            @SuppressWarnings({ "unchecked", "rawtypes" })
            @Override
            public BiFunction<?, ?, ?> builder() {
                return (context, ids) -> ((Function) builder).apply(ids);
            }
        };
    }

    public static <B, K> Lazy on(Object sourceNamespace,
                                                    BiFunction<B, Collection<K>, Map<K, ?>> builder, Object targetNamespace) {
        return new Lazy() {

            @Override
            public Object sourceNamespace() {
                return sourceNamespace;
            }

            @Override
            public Object targetNamespace() {
                return targetNamespace;
            }

            @Override
            public BiFunction<?, ?, ?> builder() {
                return builder;
            }
        };
    }

}
