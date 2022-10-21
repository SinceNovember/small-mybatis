package com.simple.mybatis;

import com.simple.mybatis.session.Configuration;
import com.simple.mybatis.session.SqlSession;
import com.simple.mybatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import static com.simple.mybatis.SqlSessionUtils.getSqlSession;

/**
 * SqlSession包装类，通过动态代理创建SqlSession
 *
 * @author SinceNovember
 * @date 2022/10/20
 */
public class SqlSessionTemplate implements SqlSession, DisposableBean {

    private static final Logger log = LoggerFactory.getLogger(SqlSessionTemplate.class);

    private final SqlSessionFactory sqlSessionFactory;

    private final SqlSession sqlSessionProxy;

    public SqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
        this.sqlSessionProxy = (SqlSession) Proxy.newProxyInstance(
                SqlSessionFactory.class.getClassLoader(),
                new Class[]{SqlSession.class},
                new SqlSessionInterceptor());
    }


    @Override
    public <T> T selectOne(String statement) {
        return sqlSessionProxy.selectOne(statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return sqlSessionProxy.selectOne(statement, parameter);
    }

    @Override
    public <E> List<E> selectList(String statement, Object parameter) {
        return sqlSessionProxy.selectOne(statement, parameter);
    }

    @Override
    public int insert(String statement, Object parameter) {
        return sqlSessionProxy.selectOne(statement, parameter);
    }

    @Override
    public int update(String statement, Object parameter) {
        return sqlSessionProxy.selectOne(statement, parameter);
    }

    @Override
    public Object delete(String statement, Object parameter) {
        return sqlSessionProxy.selectOne(statement, parameter);
    }

    @Override
    public void commit() {
        throw new UnsupportedOperationException("Manual commit is not allowed over a Spring managed SqlSession");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Manual close is not allowed over a Spring managed SqlSession");
    }

    @Override
    public void clearCache() {
        sqlSessionProxy.clearCache();
    }

    @Override
    public Configuration getConfiguration() {
        return sqlSessionProxy.getConfiguration();
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return sqlSessionProxy.getMapper(type);
    }

    @Override
    public void destroy() throws Exception {
    }

    private class SqlSessionInterceptor implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            SqlSession sqlSession = getSqlSession(SqlSessionTemplate.this.sqlSessionFactory);
            try {
                Object result = method.invoke(sqlSession, args);
                sqlSession.commit();
                return result;
            } catch (Throwable throwable) {
                log.error("execute sqlSession error ");
                throw throwable;
            } finally {
//                if (sqlSession != null) {
//                    sqlSession.close();
//                }
            }
        }
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return this.sqlSessionFactory;
    }


}
