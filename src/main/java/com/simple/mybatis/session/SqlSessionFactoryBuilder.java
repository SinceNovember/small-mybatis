package com.simple.mybatis.session;


import com.simple.mybatis.builder.xml.XMLConfigBuilder;
import com.simple.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * sql会话工厂建造者
 * 构建SqlSessionFactory的工厂
 *
 * @author SinceNovember
 * @date 2022/09/24
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }
}
