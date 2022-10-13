package com.simple.mybatis.scripting;

import com.simple.mybatis.executor.parameter.ParameterHandler;
import com.simple.mybatis.mapping.BoundSql;
import com.simple.mybatis.mapping.MappedStatement;
import com.simple.mybatis.mapping.SqlSource;
import com.simple.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * 脚本语言驱动
 *
 * @author SinceNovember
 * @date 2022/9/28
 */
public interface LanguageDriver {

    /**
     * 创建SQL源码(mapper xml方式)
     */
    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);

    /**
     * 创建SQL源码(annotation 注解方式)
     */
    SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType);

    /**
     * 创建参数处理器
     */
    ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql);
}
