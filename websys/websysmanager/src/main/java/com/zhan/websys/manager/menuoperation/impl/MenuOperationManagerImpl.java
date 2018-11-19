package com.zhan.websys.manager.menuoperation.impl;

import com.zhan.websys.dao.menuoperation.MenuOperationMapper;
import com.zhan.websys.entity.menuoperation.MenuOperation;
import com.zhan.websys.manager.base.impl.BaseManagerImpl;
import com.zhan.websys.manager.menuoperation.MenuOperationManager;
import org.springframework.stereotype.Component;

/**
 * @author zhanxp
 * @version 1.0 2018/11/19
 */
@Component
public class MenuOperationManagerImpl extends BaseManagerImpl<MenuOperationMapper, MenuOperation> implements MenuOperationManager {
}
