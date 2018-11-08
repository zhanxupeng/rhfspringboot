package com.zhan.websys.entity.role;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 角色表
 * TSYS_ROLE
 */
@Getter
@Setter
public class Role {
    /**
     * 角色ID
     * URID
     */
    private String urid;

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
}