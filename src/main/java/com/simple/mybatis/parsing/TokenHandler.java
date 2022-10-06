package com.simple.mybatis.parsing;

/**
 * 记号处理器
 *
 * @author SinceNovember
 * @date 2022/10/05
 */
public interface TokenHandler {

    String handleToken(String content);
}
