package com.simple.mybatis.executor.keygen;

import com.simple.mybatis.executor.Executor;
import com.simple.mybatis.mapping.MappedStatement;

import java.sql.Statement;

/**
 * 不用键值生成器
 *
 * @author SinceNovember
 * @date 2022/10/16
 */
public class NoKeyGenerator implements KeyGenerator{

    @Override
    public void processBefore(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
        // Do Nothing
    }

    @Override
    public void processAfter(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
        // Do Nothing
    }

}
