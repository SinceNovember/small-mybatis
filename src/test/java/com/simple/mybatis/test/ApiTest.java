package com.simple.mybatis.test;


import com.alibaba.fastjson.JSON;
import com.simple.mybatis.io.Resources;
import com.simple.mybatis.reflection.MetaObject;
import com.simple.mybatis.reflection.SystemMetaObject;
import com.simple.mybatis.session.SqlSession;
import com.simple.mybatis.session.SqlSessionFactory;
import com.simple.mybatis.session.SqlSessionFactoryBuilder;
import com.simple.mybatis.test.dao.IUserDao;
import com.simple.mybatis.test.po.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);



    @Test
    public void test_MapperProxyFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        User user = userDao.queryUserInfoById(1L);
        logger.info("测试结果：{}", JSON.toJSONString(user));

    }

}
