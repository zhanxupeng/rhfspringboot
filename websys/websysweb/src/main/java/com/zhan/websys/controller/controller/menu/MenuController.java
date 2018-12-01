package com.zhan.websys.controller.controller.menu;

import cn.hutool.core.collection.CollectionUtil;
import com.zhan.websys.api.base.PageQueryDTO;
import com.zhan.websys.api.base.PageViewVO;
import com.zhan.websys.api.base.ResultContext;
import com.zhan.websys.api.menu.MenuApi;
import com.zhan.websys.api.menu.dto.MenuAddDTO;
import com.zhan.websys.api.menu.dto.MenuDTO;
import com.zhan.websys.api.menu.dto.MenuDeleteDTO;
import com.zhan.websys.api.menu.vo.MenuVO;
import com.zhan.websys.api.menu.vo.TreeNodeVO;
import com.zhan.websys.controller.controller.base.BaseController;
import com.zhan.websys.controller.controller.menu.vo.QueryTreeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanxp
 * @version 1.0 2018/11/20
 */
@RestController
@RequestMapping("/websys/menu")
public class MenuController extends BaseController {
    @Autowired
    private MenuApi menuApi;

    @GetMapping("/display.do")
    public ResultContext<List<TreeNodeVO>> display() {
        return menuApi.queryForDisplay();
    }

    @GetMapping("/queryTree.do")
    public ResultContext<List<QueryTreeVO>> queryTree() {
        List<TreeNodeVO> list = menuApi.queryTree().getData();

        return success(convertToQueryTreeVO(list));
    }

    private List<QueryTreeVO> convertToQueryTreeVO(List<TreeNodeVO> list) {
        return list.stream().map(x -> {
            QueryTreeVO queryTreeVO = new QueryTreeVO();
            queryTreeVO.setTitle(x.getTitle());
            queryTreeVO.setValue(x.getUrid());
            if (CollectionUtil.isNotEmpty(x.getChildren())) {
                queryTreeVO.setExpand(Boolean.TRUE);
                queryTreeVO.setChildren(convertToQueryTreeVO(x.getChildren()));
            }
            return queryTreeVO;
        }).collect(Collectors.toList());
    }

    @PostMapping("query.do")
    public ResultContext<PageViewVO<MenuVO>> query(@RequestBody PageQueryDTO<MenuDTO> pageQueryDTO) {
        return menuApi.query(pageQueryDTO);
    }

    @PostMapping("add.do")
    public ResultContext<Void> add(@RequestBody MenuAddDTO menuAddDTO) {
        return menuApi.add(menuAddDTO);
    }

    @PostMapping("delete.do")
    public ResultContext<Void> delete(@RequestBody List<MenuDeleteDTO> list) {
        return menuApi.delete(list);
    }
}
