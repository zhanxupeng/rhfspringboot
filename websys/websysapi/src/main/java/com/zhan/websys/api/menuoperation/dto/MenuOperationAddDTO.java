package com.zhan.websys.api.menuoperation.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhanxp
 * @version 1.0  2018/11/25
 * @Description todo
 */
@Getter
@Setter
public class MenuOperationAddDTO {
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
}
