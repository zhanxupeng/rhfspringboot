package com.zhan.websys.api.menu.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhanxp
 * @version 1.0  2018/11/24
 * @Description todo
 */
@Setter
@Getter
public class MenuVO implements Serializable {

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
    private String activeFlagShow;

    /**
     * 上级菜单ID
     * PARENT_ID
     */
    private String parentId;
    private String parentName;

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
     * 是否在菜单树展示：0-否，1-是
     * SHOW_FLAG
     */
    private String showFlagShow;
}
