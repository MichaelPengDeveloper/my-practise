package com.wp.practise.dao.base;

import tk.mybatis.mapper.common.Mapper;

/**
 * Created by Wang Peng on 2017/6/8.
 */
public interface BaseDao<T> extends Mapper<T>, GetByIdMapper<T>{

}
