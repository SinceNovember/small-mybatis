package com.simple.mybatis.scripting.defaults;

import com.simple.mybatis.builder.SqlSourceBuilder;
import com.simple.mybatis.mapping.BoundSql;
import com.simple.mybatis.mapping.SqlSource;
import com.simple.mybatis.scripting.xmltags.DynamicContext;
import com.simple.mybatis.scripting.xmltags.SqlNode;
import com.simple.mybatis.session.Configuration;

import java.util.HashMap;

/**
 * 原始SQL源码，比 DynamicSqlSource 动态SQL处理快
 *
 * @author SinceNovember
 * @date 2022/9/28
 */
public class RawSqlSource implements SqlSource {

    private final SqlSource sqlSource;

    public RawSqlSource(Configuration configuration, SqlNode rootSqlNode, Class<?> parameterType) {
        this(configuration, getSql(configuration, rootSqlNode), parameterType);
    }

    public RawSqlSource(Configuration configuration, String sql, Class<?> parameterType) {
        SqlSourceBuilder sqlSourceParser = new SqlSourceBuilder(configuration);
        Class<?> clazz = parameterType == null ? Object.class : parameterType;
        sqlSource = sqlSourceParser.parse(sql, clazz, new HashMap<>());
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return sqlSource.getBoundSql(parameterObject);
    }

    private static String getSql(Configuration configuration, SqlNode rootSqlNode) {
        DynamicContext context = new DynamicContext(configuration, null);
        rootSqlNode.apply(context);
        return context.getSql();


    }
}
