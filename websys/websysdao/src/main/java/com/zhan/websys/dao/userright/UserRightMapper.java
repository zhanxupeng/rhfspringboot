package com.zhan.websys.dao.userright;

import com.zhan.websys.entity.userright.UserRight;

public interface UserRightMapper {
    int deleteByPrimaryKey(String urid);

    int insert(UserRight record);

    int insertSelective(UserRight record);

    UserRight selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(UserRight record);

    int updateByPrimaryKey(UserRight record);
}