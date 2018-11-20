package com.zhan.websys.manager.menuoperation;

import com.zhan.websys.entity.menuoperation.MenuOperation;
import com.zhan.websys.manager.base.BaseManager;

import java.util.List;
import java.util.Set;

/**
 * @author zhanxp
 * @version 1.0 2018/11/19
 */
public interface MenuOperationManager extends BaseManager<MenuOperation> {
    List<String> getMenuByIdList(Set<String> idList);
}
