package com.zhan.websys.api.menu;

import com.zhan.websys.api.base.PageQueryDTO;
import com.zhan.websys.api.base.PageViewVO;
import com.zhan.websys.api.base.ResultContext;
import com.zhan.websys.api.menu.dto.MenuAddDTO;
import com.zhan.websys.api.menu.dto.MenuDTO;
import com.zhan.websys.api.menu.vo.MenuVO;
import com.zhan.websys.api.menu.vo.TreeNodeVO;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
public interface MenuApi {
    ResultContext<List<TreeNodeVO>> queryForDisplay();

    ResultContext<List<TreeNodeVO>> queryTree();

    ResultContext<PageViewVO<MenuVO>> query(PageQueryDTO<MenuDTO> pageQueryDTO);

    ResultContext<Void> add(MenuAddDTO menuAddDTO);

    ResultContext<List<TreeNodeVO>> userTree();
}
