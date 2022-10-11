package com.simple.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 类型处理器
 *
 * @author SinceNovember
 * @date 2022/10/6
 */
public interface TypeHandler<T> {

    /**
     * 设置参数
     */
    void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;

    /**
     * 设置结果
     */
    T getResult(ResultSet rs, String columnName) throws SQLException;
}
