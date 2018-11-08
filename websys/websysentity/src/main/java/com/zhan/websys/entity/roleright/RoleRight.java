package com.zhan.websys.entity.roleright;

import com.zhan.websys.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 角色权限表
 * TSYS_ROLE_RIGHT
 */
@Getter
@Setter
public class RoleRight extends BaseEntity {

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

}