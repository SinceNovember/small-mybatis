package com.simple.mybatis.mapping;

/**
 * @author SinceNovember
 * @description: SQL 指令类型
 * @date 2022/9/11
 */

public enum SqlCommandType {

    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 插入
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查找
     */
    SELECT;

}
