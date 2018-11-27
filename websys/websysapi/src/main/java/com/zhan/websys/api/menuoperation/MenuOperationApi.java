package com.zhan.websys.api.menuoperation;

import com.zhan.websys.api.base.ResultContext;
import com.zhan.websys.api.menuoperation.dto.MenuOperationAddDTO;
import com.zhan.websys.api.menuoperation.dto.MenuOperationEditDTO;

/**
 * @author zhanxp
 * @version 1.0 2018/11/27
 */
public interface MenuOperationApi {
    ResultContext<Void> add(MenuOperationAddDTO menuOperationAddDTO);

    ResultContext<Void> edit(MenuOperationEditDTO menuOperationEditDTO);
}
