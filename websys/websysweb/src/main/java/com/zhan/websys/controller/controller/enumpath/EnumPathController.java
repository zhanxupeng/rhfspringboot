package com.zhan.websys.controller.controller.enumpath;

import cn.hutool.core.lang.Assert;
import com.zhan.websys.api.enumpath.EnumPathApi;
import com.zhan.websys.api.enumpath.vo.DropDownVO;
import com.zhan.websys.common.bean.ResultContext;
import com.zhan.websys.controller.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0 2018/11/15
 */
@RestController
@RequestMapping("/websys/enumPath")
public class EnumPathController extends BaseController {
    @Autowired
    private EnumPathApi enumPathApi;

    @GetMapping("/getEnum.pub")
    ResultContext<List<DropDownVO>> getEnum(String code) {
        Assert.notBlank(code, "枚举编号不能为空");
        return enumPathApi.getDropDown(code);
    }

}
