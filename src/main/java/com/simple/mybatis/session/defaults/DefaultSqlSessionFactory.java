package com.simple.mybatis.session.defaults;

import com.simple.mybatis.binding.MapperRegistry;
import com.simple.mybatis.session.Configuration;
import com.simple.mybatis.session.SqlSession;
import com.simple.mybatis.session.SqlSessionFactory;

/**
 * @author SinceNovember
 * @description: 默认的 DefaultSqlSessionFactory
 * @date 2022/9/11
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }

}
