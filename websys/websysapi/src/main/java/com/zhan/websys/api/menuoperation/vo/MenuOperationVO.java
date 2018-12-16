package com.zhan.websys.api.menuoperation.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhanxp
 * @version 1.0  2018/12/16
 * @Description todo
 */
@Getter
@Setter
public class MenuOperationVO implements Serializable {

    private String urid;
    private Long version;


    /**
     * 菜单ID
     * MENU_ID
     */
    private String menuId;

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
    private String activeFlagShow;
}
