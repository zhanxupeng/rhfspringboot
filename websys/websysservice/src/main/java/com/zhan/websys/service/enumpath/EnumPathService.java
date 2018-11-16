package com.zhan.websys.service.enumpath;

import com.zhan.websys.bo.dropdown.DropDownBO;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0 2018/10/24
 */
public interface EnumPathService {
    List<DropDownBO> getDropDown(String code);
}
