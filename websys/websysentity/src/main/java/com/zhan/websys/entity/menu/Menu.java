package com.zhan.websys.entity.menu;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 系统菜单表
 * TSYS_MENU
 */
@Getter
@Setter
public class Menu {
    /**
     * 菜单ID
     * URID
     */
    private String urid;

    /**
     * 菜单编码
     * CODE
     */
    private String code;

    /**
     * 菜单名称
     * NAME
     */
    private String name;

    /**
     * 菜单图标
     * ICON
     */
    private String icon;

    /**
     * 菜单请求地址
     * URL
     */
    private String url;

    /**
     * 是否启用：0-否，1-是
     * ACTIVE_FLAG
     */
    private String activeFlag;

    /**
     * 上级菜单ID
     * PARENT_ID
     */
    private String parentId;

    /**
     * 菜单索引路径
     * INDEX_PATH
     */
    private String indexPath;

    /**
     * 排序
     * ORDER_NO
     */
    private Integer orderNo;

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
     * 是否在菜单树展示：0-否，1-是
     * SHOW_FLAG
     */
    private String showFlag;
}