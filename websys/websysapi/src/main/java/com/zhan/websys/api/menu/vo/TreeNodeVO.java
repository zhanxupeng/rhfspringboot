package com.zhan.websys.api.menu.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhanxp
 * @version 1.0 2018/11/20
 */
@Getter
@Setter
@ToString
public class TreeNodeVO implements Serializable {
    private static final long serialVersionUID = 992753296337119909L;
    private String urid;

    private String title;

    private String checked;

    private String pid;

    private String url;

    private List<TreeNodeVO> children;
}
