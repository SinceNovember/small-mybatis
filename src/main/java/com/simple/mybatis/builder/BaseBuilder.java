package com.simple.mybatis.builder;

import com.simple.mybatis.session.Configuration;
import com.simple.mybatis.type.TypeAliasRegistry;
import com.simple.mybatis.type.TypeHandlerRegistry;

/**
 * @author SinceNovember
 * @description: 构建器的基类，建造者模式
 * @date 2022/9/11
 */

public class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    protected final TypeHandlerRegistry typeHandlerRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
        this.typeHandlerRegistry = this.configuration.getTypeHandlerRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    protected Class<?> resolveAlias(String alias) {
        return typeAliasRegistry.resolveAlias(alias);
    }
}

