package com.simple.mybatis.scripting.xmltags;

/**
 * 静态文本SQL节点
 *
 * @author SinceNovember
 * @date 2022/9/28
 */
public class StaticTextSqlNode implements SqlNode{

    private String text;

    public StaticTextSqlNode(String text) {
        this.text = text;
    }
    @Override
    public boolean apply(DynamicContext context) {
        //将文本加入context
        context.appendSql(text);
        return true;
    }
}
