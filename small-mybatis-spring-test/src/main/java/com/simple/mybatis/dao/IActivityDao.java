package com.simple.mybatis.dao;


import com.simple.mybatis.annotations.Mapper;
import com.simple.mybatis.po.Activity;

@Mapper
public interface IActivityDao {

    Activity queryActivityById(Activity activity);

}
