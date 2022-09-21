package com.simple.mybatis.session.defaults;

import com.simple.mybatis.binding.MapperRegistry;
import com.simple.mybatis.executor.Executor;
import com.simple.mybatis.mapping.Environment;
import com.simple.mybatis.session.Configuration;
import com.simple.mybatis.session.SqlSession;
import com.simple.mybatis.session.SqlSessionFactory;
import com.simple.mybatis.session.TransactionIsolationLevel;
import com.simple.mybatis.transaction.Transaction;
import com.simple.mybatis.transaction.TransactionFactory;

import java.sql.SQLException;

/**
 * @author SinceNovember
 * @description: 默认的 DefaultSqlSessionFactory
 * @date 2022/9/11
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        Transaction tx = null;
        try {
            final Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();
            tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);
            // 创建执行器
            final Executor executor = configuration.newExecutor(tx);
            // 创建DefaultSqlSession
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            try {
                assert tx != null;
                tx.close();
            } catch (SQLException ignore) {
            }
            throw new RuntimeException("Error opening session.  Cause: " + e);
        }

    }

}
