package com.simple.mybatis.executor.keygen;

import com.simple.mybatis.executor.Executor;
import com.simple.mybatis.mapping.MappedStatement;
import com.simple.mybatis.reflection.MetaObject;
import com.simple.mybatis.session.Configuration;
import com.simple.mybatis.type.TypeHandler;
import com.simple.mybatis.type.TypeHandlerRegistry;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 使用 JDBC3 Statement.getGeneratedKeys
 *
 * @author SinceNovember
 * @date 2022/10/16
 */
public class Jdbc3KeyGenerator implements KeyGenerator{
    @Override
    public void processBefore(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {

    }

    @Override
    public void processAfter(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {

    }

    public void processBatch(MappedStatement ms, Statement stmt, List<Object> parameters) {
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            final Configuration configuration = ms.getConfiguration();
            final TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            final String[] keyProperties = ms.getKeyProperties();
            final ResultSetMetaData rsmd = rs.getMetaData();
            TypeHandler<?>[] typeHandlers = null;
            if (keyProperties != null && rsmd.getColumnCount() >= keyProperties.length) {
                for (Object parameter : parameters) {
                    if (!rs.next()) {
                        break;
                    }
                }
                final MetaObject metaParam = configuration.newMetaObject(parameters);
                if (typeHandlers == null) {
                    typeHandlers = getTypeHandlers(typeHandlerRegistry, metaParam, keyProperties);
                }
            }
        }  catch (Exception e) {
            throw new RuntimeException("Error getting generated key or setting result to parameter object. Cause: " + e, e);
        }
    }

    private TypeHandler<?>[] getTypeHandlers(TypeHandlerRegistry typeHandlerRegistry, MetaObject metaParam, String[] keyProperties) {
        TypeHandler<?>[] typeHandlers = new TypeHandler<?>[keyProperties.length];
        for (int i = 0; i < keyProperties.length; i++) {
            if (metaParam.hasSetter(keyProperties[i])) {
                Class<?> keyPropertyType = metaParam.getGetterType(keyProperties[i]);
                TypeHandler<?> th = typeHandlerRegistry.getTypeHandler(keyPropertyType, null);
                typeHandlers[i] = th;
            }
        }
        return typeHandlers;
    }

    private void populateKeys(ResultSet rs, MetaObject metaParam, String[] keyProperties, TypeHandler<?>[] typeHandlers) throws SQLException {
        for (int i = 0; i < keyProperties.length; i++) {
            TypeHandler<?> th = typeHandlers[i];
            if (th != null) {
                Object value = th.getResult(rs, i + 1);
                metaParam.setValue(keyProperties[i], value);
            }
        }
    }
}
