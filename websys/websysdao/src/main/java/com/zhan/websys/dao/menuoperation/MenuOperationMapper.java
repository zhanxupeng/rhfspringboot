package com.zhan.websys.dao.menuoperation;

import com.zhan.websys.dao.base.BaseMapper;
import com.zhan.websys.entity.menuoperation.MenuOperation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface MenuOperationMapper extends BaseMapper<MenuOperation> {
    List<String> getMenuByIdList(@Param("idList") Set<String> idList);
}