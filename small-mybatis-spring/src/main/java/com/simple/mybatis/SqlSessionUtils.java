package com.simple.mybatis;

import com.simple.mybatis.session.SqlSession;
import com.simple.mybatis.session.SqlSessionFactory;

import java.util.Map;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/10/20
 */
public final class SqlSessionUtils {

    private static ThreadLocal<Map<SqlSessionFactory, SqlSession>> threadLocal = new ThreadLocal<>();

    public static SqlSession getSqlSession(SqlSessionFactory sqlSessionFactory) {
        Map<SqlSessionFactory, SqlSession> map = threadLocal.get();
        if (map != null) {
            if (map.get(sqlSessionFactory) != null) {
                return map.get(sqlSessionFactory);
            }
        }
        SqlSession sqlSession = sqlSessionFactory.openSession();
        registerSqlSession(sqlSessionFactory, sqlSession);
        return sqlSession;
    }

    public static void registerSqlSession(SqlSessionFactory sqlSessionFactory, SqlSession sqlSession) {
        Map<SqlSessionFactory, SqlSession> map = threadLocal.get();
        if (map != null) {
            map.put(sqlSessionFactory, sqlSession);
        }
    }


}
