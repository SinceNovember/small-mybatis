package com.simple.mybatis.session.defaults;

import com.simple.mybatis.binding.MapperRegistry;
import com.simple.mybatis.executor.Executor;
import com.simple.mybatis.mapping.BoundSql;
import com.simple.mybatis.mapping.Environment;
import com.simple.mybatis.mapping.MappedStatement;
import com.simple.mybatis.session.Configuration;
import com.simple.mybatis.session.SqlSession;

import javax.xml.transform.Result;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author pacvue
 * @description: TODO
 * @date 2022/9/11 13:40
 */

public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> T selectOne(String statement) {
        return this.selectOne(statement, null);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement ms = configuration.getMappedStatement(statement);
        List<T> list = executor.query(ms, parameter, Executor.NO_RESULT_HANDLER, ms.getBoundSql());
        return list.get(0);
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
