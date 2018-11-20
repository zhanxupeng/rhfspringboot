package com.zhan.websys.api.menu;

import com.zhan.websys.api.menu.vo.TreeNodeVO;
import com.zhan.websys.common.bean.ResultContext;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
public interface MenuApi {
    ResultContext<List<TreeNodeVO>> queryForDisplay();
}
