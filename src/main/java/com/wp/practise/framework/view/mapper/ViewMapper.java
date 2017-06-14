package com.wp.practise.framework.view.mapper;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Wang Peng on 2017/6/14.
 */
public interface ViewMapper {

    <M, V, B> V map(M model, B buildContext);

    default <M, V, B> List<V> map(Collection<M> models, B buildContext) {
        return models.stream().map(i -> this.<M, V, B> map(i, buildContext)).collect(toList());
    }

}
