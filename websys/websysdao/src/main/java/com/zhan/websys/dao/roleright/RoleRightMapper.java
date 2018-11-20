package com.zhan.websys.dao.roleright;

import com.zhan.websys.dao.base.BaseMapper;
import com.zhan.websys.entity.roleright.RoleRight;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleRightMapper extends BaseMapper<RoleRight> {

    List<RoleRight> getByRole(@Param("roleIdList") List<String> roleIdList);
}