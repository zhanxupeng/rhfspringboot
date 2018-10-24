package com.zhan.websys.service.enumpath;

import com.zhan.websys.dao.dropdown.DropDown;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0 2018/10/24
 */
public interface EnumPathService {
    List<DropDown> getDropDown(String code);
}
