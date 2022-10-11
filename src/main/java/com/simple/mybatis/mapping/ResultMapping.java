package com.simple.mybatis.mapping;

import com.simple.mybatis.session.Configuration;
import com.simple.mybatis.type.JdbcType;
import com.simple.mybatis.type.TypeHandler;

/**
 * 结果映射
 *
 * @author SinceNovember
 * @date 2022/10/10
 */
public class ResultMapping {

    private Configuration configuration;
    private String property;
    private String column;
    private Class<?> javaType;
    private JdbcType jdbcType;
    private TypeHandler<?> typeHandler;

    ResultMapping() {
    }

    public static class Builder {
        private ResultMapping resultMapping = new ResultMapping();


    }

}
