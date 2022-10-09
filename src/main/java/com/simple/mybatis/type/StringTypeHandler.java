package com.simple.mybatis.type;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/10/8
 */
public class StringTypeHandler extends BaseTypeHandler<String>{

    @Override
    protected void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter);
    }
}
