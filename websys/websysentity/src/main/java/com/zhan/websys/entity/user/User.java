package com.zhan.websys.entity.user;

import com.zhan.websys.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 用户表
 * TSYS_USER
 */
@Getter
@Setter
public class User extends BaseEntity {

    /**
     * 登录ID
     * LOGIN_ID
     */
    private String loginId;

    /**
     * 密码
     * PASSWORD
     */
    private String password;

    /**
     * 用户名称
     * NAME
     */
    private String name;

    /**
     * 用户类型：1-全局管理员 2-租户管理员 3-普通用户
     * TYPE
     */
    private String type;

    /**
     * 用户状态：0-正常 1-注销 2-禁用 3-锁定
     * USER_STATUS
     */
    private String userStatus;

    /**
     * 密码修改时间
     * PWD_MODIFY_DATE
     */
    private Date pwdModifyDate;

    /**
     * 用户手机号
     * MOBILE
     */
    private String mobile;

    /**
     * 用户邮箱
     * EMAIL
     */
    private String email;

    /**
     * 排序
     * ORDER_NO
     */
    private Integer orderNo;

    /**
     * LOCK_STATUS
     */
    private String lockStatus;
}