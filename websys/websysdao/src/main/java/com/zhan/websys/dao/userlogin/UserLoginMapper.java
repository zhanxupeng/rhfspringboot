package com.zhan.websys.dao.userlogin;

import com.zhan.websys.entity.userlogin.UserLogin;

public interface UserLoginMapper {
    int insert(UserLogin record);

    UserLogin selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(UserLogin record);
}