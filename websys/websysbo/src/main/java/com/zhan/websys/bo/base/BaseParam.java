package com.zhan.websys.bo.base;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhanxp
 * @version 1.0  2018/11/24
 * @Description todo
 */
@Getter
@Setter
public class BaseParam{
    private Integer pageNum;
    private Integer pageSize;
    private String orderColumn;
    private String orderBy;
}
