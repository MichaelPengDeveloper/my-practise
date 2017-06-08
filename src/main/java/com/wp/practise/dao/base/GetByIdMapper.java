package com.wp.practise.dao.base;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.Collection;
import java.util.List;

/**
 * Created by Wang Peng on 2017/6/8.
 */
public interface GetByIdMapper<T> {
    @SelectProvider(
            type = GetByIdsProvider.class,
            method = "dynamicSQL"
    )
    List<T> getByIds(@Param("ids") Collection<?> ids);
}
