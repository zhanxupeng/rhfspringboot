package com.zhan.websys.api.menuoperation.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhanxp
 * @version 1.0 2018/11/27
 */
@Getter
@Setter
public class MenuOperationEditDTO implements Serializable {
    private String urid;

    /**
     * 菜单操作代码
     * CODE
     */
    private String code;

    /**
     * 菜单操作名称
     * NAME
     */
    private String name;

    /**
     * 操作请求地址
     * URL
     */
    private String url;

    /**
     * 是否启用：0-否；1-是
     * ACTIVE_FLAG
     */
    private String activeFlag;

    private Integer rowVersion;
}
