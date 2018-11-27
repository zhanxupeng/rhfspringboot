package com.zhan.websys.service.menuoperation.impl;

import com.zhan.websys.bo.treeparser.TreeNodeBO;
import com.zhan.websys.common.loginuser.UserContext;
import com.zhan.websys.entity.menuoperation.MenuOperation;
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
    private MenuOperationManager menuOperationManager;

    @Autowired
    private UserRightManager userRightManager;

    @Override
    public List<TreeNodeBO> getOperationNode() {
        List<MenuOperation> list = menuOperationManager.find(new MenuOperation());

        Set<String> userOperation = userRightManager.getRightIdByRole(UserContext.getUserId());

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
}
