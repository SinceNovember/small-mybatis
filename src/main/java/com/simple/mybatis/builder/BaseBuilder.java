package com.simple.mybatis.builder;

import com.simple.mybatis.session.Configuration;

/**
 * @author SinceNovember
 * @description: 构建器的基类，建造者模式
 * @date 2022/9/11
 */

public class BaseBuilder {

    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
