package com.simple.mybatis.test.dao;

import com.simple.mybatis.annotations.Mapper;
import com.simple.mybatis.test.po.Activity;

@Mapper
public interface IActivityDao {

    Activity queryActivityById(Activity activity);

}
