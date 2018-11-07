package com.zhan.websys.dao.menuoperation;

import com.zhan.websys.entity.menuoperation.MenuOperation;

public interface MenuOperationMapper {
    int deleteByPrimaryKey(String urid);

    int insert(MenuOperation record);

    int insertSelective(MenuOperation record);

    MenuOperation selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(MenuOperation record);

    int updateByPrimaryKey(MenuOperation record);
}