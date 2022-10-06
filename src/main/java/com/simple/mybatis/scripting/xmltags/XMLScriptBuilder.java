package com.simple.mybatis.scripting.xmltags;

import com.simple.mybatis.builder.BaseBuilder;
import com.simple.mybatis.mapping.SqlSource;
import com.simple.mybatis.scripting.LanguageDriver;
import com.simple.mybatis.scripting.defaults.RawSqlSource;
import com.simple.mybatis.session.Configuration;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 *  XML脚本构建器
 *
 * @author SinceNovember
 * @date 2022/9/28
 */
public class XMLScriptBuilder extends BaseBuilder {

    private Element element;
    private boolean isDynamic;
    private Class<?> parameterType;


    public XMLScriptBuilder(Configuration configuration, Element element, Class<?> parameterType) {
        super(configuration);
        this.element = element;
        this.parameterType = parameterType;
    }

    public SqlSource parseScriptNode() {
        List<SqlNode> contents = parseDynamicTag(element);
        MixedSqlNode rootSqlNode = new MixedSqlNode(contents);
        return new RawSqlSource(configuration, rootSqlNode, parameterType);
    }

    private List<SqlNode> parseDynamicTag(Element element) {
        List<SqlNode> contents = new ArrayList<>();
        // element.getText 拿到 SQL
        String data = element.getText();
        contents.add(new StaticTextSqlNode(data));
        return contents;
    }
}
