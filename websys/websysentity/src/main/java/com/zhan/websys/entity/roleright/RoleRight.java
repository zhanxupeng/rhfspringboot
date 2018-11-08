package com.zhan.websys.entity.roleright;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 角色权限表
 * TSYS_ROLE_RIGHT
 */
@Getter
@Setter
public class RoleRight {
    /**
     * 角色权限ID
     * URID
     */
    private String urid;

    /**
     * 菜单操作ID
     * OPERATION_ID
     */
    private String operationId;

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