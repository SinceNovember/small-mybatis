package com.simple.mybatis;


import com.simple.mybatis.annotation.MapperScan;
import com.simple.mybatis.annotations.Mapper;
import com.simple.mybatis.dao.IActivityDao;
import com.simple.mybatis.po.Activity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * .
 *
 * @author SinceNovember
 * @date 2022/10/21
 */
@SpringBootApplication
@MapperScan(value = "com.simple.mybatis.dao", annotationClass = Mapper.class)
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Test.class, args);
        IActivityDao bean = applicationContext.getBean(IActivityDao.class);
        Activity req = new Activity();
        req.setActivityId(100001L);
        Activity activity = bean.queryActivityById(req);
        System.out.println(activity);
    }
}
