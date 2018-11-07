package com.zhan.websys.dao.role;

import com.zhan.websys.entity.role.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(String urid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}