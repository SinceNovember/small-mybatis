package com.simple.mybatis.builder;

import com.simple.mybatis.mapping.BoundSql;
import com.simple.mybatis.mapping.ParameterMapping;
import com.simple.mybatis.mapping.SqlSource;
import com.simple.mybatis.session.Configuration;

import java.util.List;

/**
 * 静态SQL源码
 *
 * @author SinceNovember
 * @date 2022/10/5
 */
public class StaticSqlSource implements SqlSource {

    private String sql;
    private List<ParameterMapping> parameterMappings;
    private Configuration configuration;

    public StaticSqlSource(Configuration configuration, String sql) {
        this(configuration, sql, null);
    }

    public StaticSqlSource(Configuration configuration, String sql, List<ParameterMapping> parameterMappings) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
        this.configuration = configuration;
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return new BoundSql(configuration, sql, parameterMappings, parameterObject);
    }
}
