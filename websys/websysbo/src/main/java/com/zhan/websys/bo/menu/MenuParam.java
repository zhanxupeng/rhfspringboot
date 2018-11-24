package com.zhan.websys.bo.menu;

import com.zhan.websys.bo.base.BaseParam;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhanxp
 * @version 1.0  2018/11/24
 * @Description todo
 */
@Getter
@Setter
public class MenuParam extends BaseParam {
    private String parentId;
    private String code;
    private String name;
}
