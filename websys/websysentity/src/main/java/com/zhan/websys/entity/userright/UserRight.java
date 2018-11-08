package com.zhan.websys.entity.userright;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 用户权限表
 * TSYS_USER_RIGHT
 */
@Getter
@Setter
public class UserRight {
    /**
     * 用户权限ID
     * URID
     */
    private String urid;

    /**
     * 菜单操作ID
     * OPERATION_ID
     */
    private String operationId;

    /**
     * 用户ID
     * USER_ID
     */
    private String userId;

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