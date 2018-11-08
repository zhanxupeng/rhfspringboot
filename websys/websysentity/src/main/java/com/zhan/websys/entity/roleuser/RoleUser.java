package com.zhan.websys.entity.roleuser;

import com.zhan.websys.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 用户角色表
 * TSYS_ROLE_USER
 */
@Getter
@Setter
public class RoleUser extends BaseEntity {

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
}