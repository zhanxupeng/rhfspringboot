package com.zhan.websys.entity.roleuser;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 用户角色表
 * TSYS_ROLE_USER
 */
@Getter
@Setter
public class RoleUser {
    /**
     * 用户角色ID
     * URID
     */
    private String urid;

    /**
     * 用户ID
     * USER_ID
     */
    private String userId;

    /**
     * 角色ID
     * ROLE_ID
     */
    private String roleId;

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