package com.simple.mybatis.mapping;

/**
 * sql源码
 *
 * @author SinceNovember
 * @date 2022/09/28
 */
public interface SqlSource {

    BoundSql getBoundSql(Object parameterObject);
}
