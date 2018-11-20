package com.zhan.websys.controller.controller.menu;

import com.zhan.websys.api.menu.MenuApi;
import com.zhan.websys.api.menu.vo.TreeNodeVO;
import com.zhan.websys.common.bean.ResultContext;
import com.zhan.websys.controller.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
