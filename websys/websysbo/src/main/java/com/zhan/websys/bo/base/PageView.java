package com.zhan.websys.bo.base;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0  2018/11/24
 * @Description todo
 */
@Getter
@Setter
public class PageView<T> {
    private Long total;
    private Integer size;
    private List<T> data;
}
