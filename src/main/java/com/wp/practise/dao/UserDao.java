package com.wp.practise.dao;

import com.wp.practise.model.User;
import com.wp.practise.framework.mybatis.BaseDAO;
import org.springframework.stereotype.Repository;

/**
 * Created by Wang Peng on 2017/6/8.
 */
@Repository
public interface UserDao extends BaseDAO<User> {
}
