package com.zhan.websys.service.menu;

import com.zhan.websys.bo.base.PageView;
import com.zhan.websys.bo.treeparser.TreeNodeBO;
import com.zhan.websys.entity.base.PageQuery;
import com.zhan.websys.entity.menu.Menu;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0 2018/11/19
 */
public interface MenuService {

    List<TreeNodeBO> queryForDisplay();

    List<TreeNodeBO> queryTree();

    PageView<Menu> query(PageQuery<Menu> pageQuery);
}
