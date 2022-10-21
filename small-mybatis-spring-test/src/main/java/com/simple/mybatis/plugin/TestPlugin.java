//package com.simple.mybatis.plugin;
//
//import com.simple.mybatis.executor.statement.StatementHandler;
//import com.simple.mybatis.mapping.BoundSql;
//import org.apache.ibatis.plugin.Intercepts;
//import org.apache.ibatis.plugin.Signature;
//
//import java.sql.Connection;
//import java.util.Properties;
//
///**
// * .
// *
// * @author SinceNovember
// * @date 2022/10/18
// */
//
//@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
//public class TestPlugin implements Interceptor {
//
//    @Override
//    public Object intercept(Invocation invocation)  throws Throwable {
//        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
//        BoundSql boundSql = statementHandler.getBoundSql();
//        String sql = boundSql.getSql();
//        // 输出SQL
//        System.out.println("拦截SQL：" + sql);
//        return invocation.proceed();
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//        System.out.println("参数输出：" + properties.getProperty("test00"));
//    }
//}
