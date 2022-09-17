package com.simple.mybatis.test.dao;

import com.simple.mybatis.test.po.User;

public interface IUserDao {

    User queryUserInfoById(Long uId);

}
