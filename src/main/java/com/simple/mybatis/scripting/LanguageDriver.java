package com.simple.mybatis.scripting;

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

    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);
}
