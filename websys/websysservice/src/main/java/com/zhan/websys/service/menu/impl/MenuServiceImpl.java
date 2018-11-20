package com.zhan.websys.service.menu.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.zhan.websys.bo.treeparser.TreeNode;
import com.zhan.websys.common.loginuser.UserContext;
import com.zhan.websys.entity.menu.Menu;
import com.zhan.websys.entity.roleuser.RoleUser;
import com.zhan.websys.manager.menu.MenuManager;
import com.zhan.websys.manager.menuoperation.MenuOperationManager;
import com.zhan.websys.manager.roleright.RoleRightManager;
import com.zhan.websys.manager.roleuser.RoleUserManager;
import com.zhan.websys.manager.userright.UserRightManager;
import com.zhan.websys.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhanxp
 * @version 1.0 2018/11/19
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private RoleUserManager roleUserManager;
    @Autowired
    private RoleRightManager roleRightManager;
    @Autowired
    private UserRightManager userRightManager;
    @Autowired
    private MenuOperationManager menuOperationManager;
    @Autowired
    private MenuManager menuManager;

    @Override
    public List<TreeNode> queryForDisplay() {
        RoleUser roleUser = new RoleUser();
        roleUser.setUserId(UserContext.getUserId());
        Set<String> allOperations = new HashSet<>();
        //获取角色权限
        List<String> roleIdList = roleUserManager.find(roleUser).stream()
                .map(RoleUser::getRoleId).collect(Collectors.toList());

        if (CollectionUtil.isNotEmpty(roleIdList)) {
            Set<String> roleOperationList = roleRightManager.getRightIdByRole(roleIdList);
            allOperations.addAll(roleOperationList);
        }

        //获取用户权限
        Set<String> userOperationList = userRightManager.getRightIdByRole(UserContext.getUserId());
        allOperations.addAll(userOperationList);

        List<String> allMenuList = new LinkedList<>();
        List<String> menuIdList = menuOperationManager.getMenuByIdList(allOperations);
        do {
            allMenuList.addAll(menuIdList);
            menuIdList = menuManager.getParentIdByIdList(menuIdList);
        } while (CollectionUtil.isNotEmpty(menuIdList));

        List<Menu> menuList = menuManager.getByIdList(allMenuList);

        return getMenuTreeNode(menuList);
    }
//
//    public static void main(String[] args) {
//        MenuServiceImpl menuService = new MenuServiceImpl();
//
//        Menu menu = new Menu();
//        menu.setUrid("111");
//        menu.setParentId("");
//        menu.setName("不知道");
//
//        Menu menu1 = new Menu();
//        menu1.setUrid("222");
//        menu1.setParentId("111");
//        menu1.setName("啊啊啊");
//
//        Menu menu2 = new Menu();
//        menu2.setUrid("333");
//        menu2.setParentId("");
//        menu2.setName("不知道1");
//
//        Menu menu3 = new Menu();
//        menu3.setUrid("444");
//        menu3.setParentId("333");
//        menu3.setName("啊啊啊");
//
//        Menu menu4 = new Menu();
//        menu4.setUrid("555");
//        menu4.setParentId("333");
//        menu4.setName("哦哦哦");
//
//        System.out.println(menuService.getMenuTreeNode(Arrays.asList(menu, menu1, menu2, menu3, menu4)));
//    }

    /**
     * 获取菜单树
     *
     * @param menuList
     * @return
     */
    private List<TreeNode> getMenuTreeNode(List<Menu> menuList) {
        List<TreeNode> treeNodeList = menuList.stream()
                .filter(x -> StrUtil.isBlank(x.getParentId()))
                .map(this::convertToTreeNode).collect(Collectors.toList());

        treeNodeList.forEach(x -> x.setChildren(getChildren(x, menuList)));
        return treeNodeList;
    }

    /**
     * 获取子节点
     *
     * @param treeNode
     * @param menuList
     * @return
     */
    private List<TreeNode> getChildren(TreeNode treeNode, List<Menu> menuList) {
        List<TreeNode> list = menuList.stream().filter(x -> treeNode.getId().equals(x.getParentId())).map(this::convertToTreeNode).collect(Collectors.toList());

        if (CollectionUtil.isNotEmpty(list)) {
            list.forEach(x -> x.setChildren(getChildren(x, menuList)));
        }
        return list;
    }

    /**
     * 菜单对象->树对象
     *
     * @param x
     * @return
     */
    private TreeNode convertToTreeNode(Menu x) {
        TreeNode treeNodeN = new TreeNode();
        treeNodeN.setId(x.getUrid());
        treeNodeN.setPid(x.getParentId());
        treeNodeN.setTitle(x.getName());
        treeNodeN.setUrl(x.getUrl());
        treeNodeN.setChecked(Boolean.FALSE.toString());
        return treeNodeN;
    }
}
