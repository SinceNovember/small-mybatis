package com.simple.mybatis.scripting.xmltags;

/**
 * SQL 节点
 *
 * @author SinceNovember
 * @date 2022/09/28
 */
public interface SqlNode {

    boolean apply(DynamicContext context);

}
