package com.zhan.websys.dao.userlogin;

import com.zhan.websys.entity.userlogin.UserLogin;

public interface UserLoginMapper {
    int deleteByPrimaryKey(String urid);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);
}