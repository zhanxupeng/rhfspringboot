package com.zhan.websys.dao.roleright;

import com.zhan.websys.entity.roleright.RoleRight;

public interface RoleRightMapper {
    int insert(RoleRight record);

    RoleRight selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(RoleRight record);
}