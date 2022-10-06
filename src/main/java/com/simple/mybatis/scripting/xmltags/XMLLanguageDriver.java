package com.simple.mybatis.scripting.xmltags;

import com.simple.mybatis.mapping.SqlSource;
import com.simple.mybatis.scripting.LanguageDriver;
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

}
