package com.zhan.websys.manager.menu;

import com.zhan.websys.entity.menu.Menu;
import com.zhan.websys.manager.base.BaseManager;

import java.util.Collection;
import java.util.List;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
public interface MenuManager extends BaseManager<Menu> {
    List<String> getParentIdByIdList(Collection<String> idList);

    List<Menu> getByIdList(Collection<String> idList);

    void enable(List<Menu> list);

    void disable(List<Menu> list);
}
