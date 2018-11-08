package com.zhan.websys.dao.menu;

import com.zhan.websys.entity.menu.Menu;

public interface MenuMapper {
    int insert(Menu record);

    Menu selectByPrimaryKey(String urid);

    int updateByPrimaryKeySelective(Menu record);
}