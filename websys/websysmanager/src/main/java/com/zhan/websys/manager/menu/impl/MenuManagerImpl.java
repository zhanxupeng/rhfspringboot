package com.zhan.websys.manager.menu.impl;

import com.zhan.websys.dao.menu.MenuMapper;
import com.zhan.websys.entity.menu.Menu;
import com.zhan.websys.manager.base.impl.BaseManagerImpl;
import com.zhan.websys.manager.menu.MenuManager;
import org.springframework.stereotype.Component;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
@Component
public class MenuManagerImpl extends BaseManagerImpl<MenuMapper, Menu> implements MenuManager {
}
