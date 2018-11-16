package com.zhan.websys.api.enumpath;

import com.zhan.websys.api.enumpath.vo.DropDownVO;
import com.zhan.websys.common.bean.ResultContext;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0 2018/11/15
 */
public interface EnumPathApi {
    ResultContext<List<DropDownVO>> getDropDown(String code);
}
