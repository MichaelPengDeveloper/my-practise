package com.wp.practise.framework.view.builder;

import com.wp.practise.framework.view.builder.context.BuildContext;

import static java.util.Collections.singleton;

/**
 * Created by Wang Peng on 2017/6/14.
 */
public interface ModelBuilder <B extends BuildContext> {

    void buildMulti(Iterable<?> sources, B buildContext);

    default void buildSingle(Object one, B buildContext) {
        buildMulti(singleton(one), buildContext);
    }

}
