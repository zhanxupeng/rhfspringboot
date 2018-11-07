package com.zhan.websys.dao.user;

import com.zhan.websys.entity.user.User;

public interface UserMapper {
    int deleteByPrimaryKey(String urid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}