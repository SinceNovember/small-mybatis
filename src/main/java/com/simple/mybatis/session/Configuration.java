package com.simple.mybatis.session;

import com.simple.mybatis.binding.MapperRegistry;
import com.simple.mybatis.datasource.druid.DruidDataSourceFactory;
import com.simple.mybatis.datasource.pooled.PooledDataSourceFactory;
import com.simple.mybatis.datasource.unpooled.UnpooledDataSourceFactory;
import com.simple.mybatis.mapping.Environment;
import com.simple.mybatis.mapping.MappedStatement;
import com.simple.mybatis.transaction.jdbc.JdbcTransactionFactory;
import com.simple.mybatis.type.TypeAliasRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SinceNovember
 * @description: 配置项
 * @date 2022/9/11
 */

public class Configuration {

    //环境
    protected Environment environment;

    // 映射注册机
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    // 映射的语句，存在Map里
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    // 类型别名注册机
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);

        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
        typeAliasRegistry.registerAlias("UNPOOLED", UnpooledDataSourceFactory.class);
        typeAliasRegistry.registerAlias("POOLED", PooledDataSourceFactory.class);

    }

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

}
