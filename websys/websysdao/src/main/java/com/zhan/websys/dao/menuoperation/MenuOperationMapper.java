package com.zhan.websys.dao.menuoperation;

import com.zhan.websys.entity.menuoperation.MenuOperation;

public interface MenuOperationMapper {
    int insert(MenuOperation record);

    MenuOperation selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(MenuOperation record);
}