package com.zhan.websys.dao.role;

import com.zhan.websys.entity.role.Role;

public interface RoleMapper {
    int insert(Role record);

    Role selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(Role record);
}