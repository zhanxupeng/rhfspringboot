package com.zhan.websys.service.menu;

import com.zhan.websys.bo.treeparser.TreeNodeBO;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0 2018/11/19
 */
public interface MenuService {

    List<TreeNodeBO> queryForDisplay();

    /**
     * 用户修改权限的树形结构
     *
     * @return
     */
    List<TreeNodeBO> userTree();
}
