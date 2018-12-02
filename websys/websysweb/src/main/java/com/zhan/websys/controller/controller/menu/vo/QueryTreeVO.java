package com.zhan.websys.controller.controller.menu.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhanxp
 * @version 1.0  2018/12/1
 * @Description todo
 */
@Getter
@Setter
public class QueryTreeVO implements Serializable {
    private String title;
    private String value;
    private boolean expand;
    private List<QueryTreeVO> children;
}
