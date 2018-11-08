package com.zhan.websys.entity.role;

import com.zhan.websys.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 角色表
 * TSYS_ROLE
 */
@Getter
@Setter
public class Role extends BaseEntity {

    /**
     * 角色代码
     * CODE
     */
    private String code;

    /**
     * 角色名称
     * NAME
     */
    private String name;

    /**
     * 排序
     * ORDER_NO
     */
    private Integer orderNo;

    /**
     * 角色类型：1-全局管理员2-租户管理员3-普通用户
     * TYPE
     */
    private String type;
}