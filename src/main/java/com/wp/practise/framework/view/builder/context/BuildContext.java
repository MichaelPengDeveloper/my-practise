package com.wp.practise.framework.view.builder.context;

import java.util.Map;

/**
 * Created by Wang Peng on 2017/6/14.
 */
public interface BuildContext {

    default <K, V> Map<K, V> getData(Class<V> type) {
        return getData((Object) type);
    }

    <K, V> Map<K, V> getData(Object namespace);

    void merge(BuildContext buildContext);

}
