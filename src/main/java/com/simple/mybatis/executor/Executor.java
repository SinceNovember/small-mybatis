package com.simple.mybatis.executor;

import com.simple.mybatis.mapping.BoundSql;
import com.simple.mybatis.mapping.MappedStatement;
import com.simple.mybatis.session.ResultHandler;
import com.simple.mybatis.session.RowBounds;
import com.simple.mybatis.transaction.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 执行器
 */
public interface Executor {

    ResultHandler NO_RESULT_HANDLER = null;

    int update(MappedStatement ms, Object parameter) throws SQLException;

    <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException;

    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);

}
