package com.zhan.websys.dao.roleuser;

import com.zhan.websys.entity.roleuser.RoleUser;

public interface RoleUserMapper {
    int insert(RoleUser record);

    RoleUser selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(RoleUser record);
}