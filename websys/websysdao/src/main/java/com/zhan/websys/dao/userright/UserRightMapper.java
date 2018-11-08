package com.zhan.websys.dao.userright;

import com.zhan.websys.entity.userright.UserRight;

public interface UserRightMapper {
    int insert(UserRight record);

    UserRight selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(UserRight record);
}