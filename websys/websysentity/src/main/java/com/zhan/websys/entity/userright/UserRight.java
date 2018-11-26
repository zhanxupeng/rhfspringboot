package com.zhan.websys.entity.userright;

import com.zhan.websys.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户权限表
 * TSYS_USER_RIGHT
 */
@Getter
@Setter
public class UserRight extends BaseEntity {

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
}