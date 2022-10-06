package com.simple.mybatis.builder;

import com.simple.mybatis.session.Configuration;
import com.simple.mybatis.type.TypeAliasRegistry;

/**
 * @author SinceNovember
 * @description: 构建器的基类，建造者模式
 * @date 2022/9/11
 */

public class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();

    }

    public Configuration getConfiguration() {
        return configuration;
    }

    protected Class<?> resolveAlias(String alias) {
        return typeAliasRegistry.resolveAlias(alias);
    }
}

