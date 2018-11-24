package com.zhan.websys.api.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhanxp
 * @version 1.0  2018/11/24
 * @Description todo
 */
@Getter
@Setter
public class PageViewVO<T> implements Serializable {
    private Long total;
    private Integer size;
    private List<T> data;
}
