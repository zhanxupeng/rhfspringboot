package com.zhan.websys.manager.menu.impl;

import cn.hutool.core.util.StrUtil;
import com.zhan.common.exception.BusinessException;
import com.zhan.websys.common.enums.ENMenuActiveFlag;
import com.zhan.websys.dao.menu.MenuMapper;
import com.zhan.websys.entity.menu.Menu;
import com.zhan.websys.manager.base.impl.BaseManagerImpl;
import com.zhan.websys.manager.menu.MenuManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void enable(List<Menu> list) {
        list.forEach(x -> {
            int enable = mapper.updateActiveFlag(x.getUrid(), x.getVersion(),
                    ENMenuActiveFlag.YES.getValue(),
                    ENMenuActiveFlag.NO.getValue()
            );

            if (enable != 1) {
                throw new BusinessException("菜单启动失败，请校验状态重试");
            }
        });
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void disable(List<Menu> list) {
        list.forEach(x -> {
            int enable = mapper.updateActiveFlag(x.getUrid(), x.getVersion(),
                    ENMenuActiveFlag.NO.getValue(),
                    ENMenuActiveFlag.YES.getValue());

            if (enable != 1) {
                throw new BusinessException("菜单停用失败，请校验状态重试");
            }
        });
    }
}
