package com.zhan.websys.service.menuoperation.impl;

import com.zhan.common.loginuser.UserContext;
import com.zhan.websys.bo.base.PageView;
import com.zhan.websys.bo.treeparser.TreeNodeBO;
import com.zhan.websys.entity.base.PageQuery;
import com.zhan.websys.entity.menuoperation.MenuOperation;
import com.zhan.websys.manager.menu.MenuManager;
import com.zhan.websys.manager.menuoperation.MenuOperationManager;
import com.zhan.websys.manager.userright.UserRightManager;
import com.zhan.websys.service.menuoperation.MenuOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhanxp
 * @version 1.0 2018/11/26
 */
@Service
public class MenuOperationServiceImpl implements MenuOperationService {
    @Autowired
    private MenuManager menuManager;
    @Autowired
    private MenuOperationManager menuOperationManager;

    @Autowired
    private UserRightManager userRightManager;

    @Override
    public List<TreeNodeBO> getOperationNode() {
        List<MenuOperation> list = menuOperationManager.find(new MenuOperation());

        Set<String> userOperation = userRightManager.getRightIdByUser(UserContext.getUserId());

        return list.stream().map(x -> {
            TreeNodeBO treeNodeBO = new TreeNodeBO();
            treeNodeBO.setId(x.getUrid());
            treeNodeBO.setTitle(x.getName());
            treeNodeBO.setPid(x.getMenuId());
            treeNodeBO.setUrl(x.getUrl());
            if (userOperation.contains(x.getUrid())) {
                treeNodeBO.setChecked(Boolean.TRUE.toString());
            }
            return treeNodeBO;
        }).collect(Collectors.toList());
    }

    @Override
    public void add(MenuOperation menuOperation) {
        //校验菜单是否存在
        menuManager.getById(menuOperation.getMenuId());

        menuOperationManager.insert(menuOperation);
    }

    @Override
    public void edit(MenuOperation menuOperation) {
        menuOperationManager.update(menuOperation);
    }

    @Override
    public PageView<MenuOperation> query(PageQuery<MenuOperation> pageQuery) {
        List<MenuOperation> list = menuOperationManager.pageQuery(pageQuery);

        PageView<MenuOperation> pageView = new PageView<>();
        pageView.setData(list);
        return pageView;
    }

    @Override
    public void deletes(List<MenuOperation> list) {
        menuOperationManager.deletes(list);
    }

    @Override
    public MenuOperation getById(String urid) {
        return menuOperationManager.getById(urid);
    }
}
