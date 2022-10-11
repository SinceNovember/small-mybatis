package com.simple.mybatis.session;

/**
 * 结果上下文
 *
 * @author SinceNovember
 * @date 2022/10/11
 */
public interface ResultContext {

    /**
     * 获取结果
     */
    Object getResultObject();

    /**
     * 获取记录数
     */
    int getResultCount();


}
