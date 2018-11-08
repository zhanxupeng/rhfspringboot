package com.zhan.websys.entity.menuoperation;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 菜单操作表
 * TSYS_MENU_OPERATION
 */
@Getter
@Setter
public class MenuOperation {
    /**
     * 菜单操作ID
     * URID
     */
    private String urid;

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
     * 创建人
     * CREATOR
     */
    private String creator;

    /**
     * 创建时间
     * CREATE_DATE
     */
    private Date createDate;

    /**
     * 更新人
     * UPDATOR
     */
    private String updator;

    /**
     * 更新时间
     * UPDATE_DATE
     */
    private Date updateDate;

    /**
     * 版本号
     * VERSION
     */
    private Long version;

    /**
     * 备注
     * REMARK
     */
    private String remark;

    /**
     * 是否启用：0-否；1-是
     * ACTIVE_FLAG
     */
    private String activeFlag;
}