package com.zhan.websys.dao.roleuser;

import com.zhan.websys.entity.roleuser.RoleUser;

public interface RoleUserMapper {
    int deleteByPrimaryKey(String urid);

    int insert(RoleUser record);

    int insertSelective(RoleUser record);

    RoleUser selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(RoleUser record);

    int updateByPrimaryKey(RoleUser record);
}