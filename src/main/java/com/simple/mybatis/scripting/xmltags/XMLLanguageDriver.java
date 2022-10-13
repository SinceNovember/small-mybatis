package com.simple.mybatis.scripting.xmltags;

import com.simple.mybatis.executor.parameter.ParameterHandler;
import com.simple.mybatis.mapping.BoundSql;
import com.simple.mybatis.mapping.MappedStatement;
import com.simple.mybatis.mapping.SqlSource;
import com.simple.mybatis.scripting.LanguageDriver;
import com.simple.mybatis.scripting.defaults.DefaultParameterHandler;
import com.simple.mybatis.scripting.defaults.RawSqlSource;
import com.simple.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * XML语言驱动器
 *
 * @author SinceNovember
 * @date 2022/9/28
 */
public class XMLLanguageDriver implements LanguageDriver {

    @Override
    public SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType) {
        // 用XML脚本构建器解析
        XMLScriptBuilder builder = new XMLScriptBuilder(configuration, script, parameterType);
        return builder.parseScriptNode();
    }

    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
        return new RawSqlSource(configuration, script, parameterType);
    }

    @Override
    public ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql) {
        return new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
    }

}
