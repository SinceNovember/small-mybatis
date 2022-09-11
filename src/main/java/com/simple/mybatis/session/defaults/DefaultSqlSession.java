package com.simple.mybatis.session.defaults;

import com.simple.mybatis.binding.MapperRegistry;
import com.simple.mybatis.session.Configuration;
import com.simple.mybatis.session.SqlSession;

/**
 * @author pacvue
 * @description: TODO
 * @date 2022/9/11 13:40
 */

public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }


}
