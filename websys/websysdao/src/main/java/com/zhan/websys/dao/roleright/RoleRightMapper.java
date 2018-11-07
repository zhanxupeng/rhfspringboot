package com.zhan.websys.dao.roleright;

import com.zhan.websys.entity.roleright.RoleRight;

public interface RoleRightMapper {
    int deleteByPrimaryKey(String urid);

    int insert(RoleRight record);

    int insertSelective(RoleRight record);

    RoleRight selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(RoleRight record);

    int updateByPrimaryKey(RoleRight record);
}