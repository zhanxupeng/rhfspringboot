package com.zhan.websys.entity.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 用户表
 * TSYS_USER
 */
@Getter
@Setter
public class User {
    /**
     * 用户ID
     * URID
     */
    private String urid;

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

    /**
     * LOCK_STATUS
     */
    private String lockStatus;
}