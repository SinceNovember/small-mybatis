package com.simple.mybatis.plugin;

import java.util.Properties;

/**
 * 拦截器接口
 *
 * @author SinceNovember
 * @date 2022/10/18
 */
public interface Interceptor {

    Object intercept(Invocation invocation) throws Throwable;

    default Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    default void setProperties(Properties properties) {

    }
}
