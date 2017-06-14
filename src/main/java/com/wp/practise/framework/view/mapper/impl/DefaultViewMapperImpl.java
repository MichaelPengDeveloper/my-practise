package com.wp.practise.framework.view.mapper.impl;

import com.wp.practise.framework.view.builder.context.BuildContext;
import com.wp.practise.framework.view.mapper.ViewMapper;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiFunction;

import static org.apache.commons.lang3.ClassUtils.getAllInterfaces;
import static org.apache.commons.lang3.ClassUtils.getAllSuperclasses;

/**
 * Created by Wang Peng on 2017/6/14.
 */
public class DefaultViewMapperImpl implements ViewMapper {
    private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

    private final Map<Class<?>, BiFunction<?, ?, ?>> mappers = new HashMap<>();
    private final ConcurrentMap<Class<?>, BiFunction<?, ?, ?>> modelTypeCache = new ConcurrentHashMap<>();

    /** {@inheritDoc} */
    @SuppressWarnings({ "unchecked" })
    @Override
    public <M, V, B> V map(M model, B buildContext) {
        return (V) getMapper(model.getClass()).apply(buildContext, model);
    }

    @SuppressWarnings("rawtypes")
    private BiFunction getMapper(Class<?> modelType) {
        return modelTypeCache.computeIfAbsent(modelType, t -> {
            BiFunction<?, ?, ?> result = mappers.get(t);
            if (result == null) {
                for (Class<?> c : getAllInterfaces(t)) {
                    result = mappers.get(c);
                    if (result != null) {
                        return result;
                    }
                }
                for (Class<?> c : getAllSuperclasses(t)) {
                    result = mappers.get(c);
                    if (result != null) {
                        return result;
                    }
                }
            }
            if (result == null) {
                logger.warn("cannot found model's view:{}", modelType);
            }
            return result;
        });
    }

    /**
     * <p>addMapper.</p>
     *
     * @param modelType a {@link java.lang.Class} object.
     * @param viewFactory a {@link java.util.function.BiFunction} object.
     * @param <M> a M object.
     * @param <V> a V object.
     * @return a {@link com.github.phantomthief.view.mapper.impl.DefaultViewMapperImpl} object.
     */
    public <M, V> DefaultViewMapperImpl addMapper(Class<M> modelType,
                                                  BiFunction<BuildContext, M, V> viewFactory) {
        mappers.put(modelType, viewFactory);
        return this;
    }
}
