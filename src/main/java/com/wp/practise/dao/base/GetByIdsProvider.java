package com.wp.practise.dao.base;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

/**
 * Created by Wang Peng on 2017/6/8.
 */
public class GetByIdsProvider extends MapperTemplate {
    public GetByIdsProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String getByIds(MappedStatement ms) {
        final Class<?> entityClass = this.getEntityClass(ms);
        this.setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.selectAllColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, this.tableName(entityClass)));
        sql.append(" where id in (");
        sql.append("<foreach collection=\"ids\" item=\"e\" separator=\",\" >");
        sql.append("#{e}");
        sql.append("</foreach>");
        sql.append(")");
        return sql.toString();
    }

}
