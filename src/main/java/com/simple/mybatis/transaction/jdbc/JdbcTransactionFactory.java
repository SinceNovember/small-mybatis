package com.simple.mybatis.transaction.jdbc;

import com.simple.mybatis.session.TransactionIsolationLevel;
import com.simple.mybatis.transaction.Transaction;
import com.simple.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author SinceNovember
 * @description: JdbcTransaction 工厂
 * @date 2022/9/17
 */

public class JdbcTransactionFactory implements TransactionFactory {

    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }
}
