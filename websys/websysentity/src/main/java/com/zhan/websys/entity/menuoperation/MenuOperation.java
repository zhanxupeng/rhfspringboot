package com.zhan.websys.entity.menuoperation;

import com.zhan.websys.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 菜单操作表
 * TSYS_MENU_OPERATION
 */
@Getter
@Setter
public class MenuOperation extends BaseEntity {

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