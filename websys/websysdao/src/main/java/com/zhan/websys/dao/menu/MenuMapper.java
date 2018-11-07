package com.zhan.websys.dao.menu;

import com.zhan.websys.entity.menu.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(String urid);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}