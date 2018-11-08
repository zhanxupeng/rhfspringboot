package com.zhan.websys.dao.user;

import com.zhan.websys.entity.user.User;

public interface UserMapper {
    int insert(User record);

    User selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(User record);
}