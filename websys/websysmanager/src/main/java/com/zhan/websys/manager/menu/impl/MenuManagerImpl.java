package com.zhan.websys.manager.menu.impl;

import cn.hutool.core.util.StrUtil;
import com.zhan.websys.dao.menu.MenuMapper;
import com.zhan.websys.entity.menu.Menu;
import com.zhan.websys.manager.base.impl.BaseManagerImpl;
import com.zhan.websys.manager.menu.MenuManager;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
@Component
public class MenuManagerImpl extends BaseManagerImpl<MenuMapper, Menu> implements MenuManager {
    @Override
    public List<String> getParentIdByIdList(Collection<String> idList) {
        return mapper.getByIdList(idList).stream().map(Menu::getParentId).filter(StrUtil::isNotBlank).collect(Collectors.toList());
    }

    @Override
    public List<Menu> getByIdList(Collection<String> idList) {
        return mapper.getByIdList(idList);
    }
}
