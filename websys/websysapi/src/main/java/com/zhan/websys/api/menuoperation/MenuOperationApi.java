package com.zhan.websys.api.menuoperation;

import com.zhan.websys.api.base.ResultContext;
import com.zhan.websys.api.menuoperation.dto.MenuOperationAddDTO;

/**
 * @author zhanxp
 * @version 1.0  2018/11/25
 * @Description todo
 */
public interface MenuOperationApi {
    ResultContext<Void> add(MenuOperationAddDTO menuOperationAddDTO);
}
