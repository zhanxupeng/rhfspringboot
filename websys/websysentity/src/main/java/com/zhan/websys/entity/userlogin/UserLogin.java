package com.zhan.websys.entity.userlogin;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 用户登录表
 * TSYS_USER_LOGIN
 */
@Getter
@Setter
public class UserLogin {
    /**
     * URID
     * URID
     */
    private String urid;

    /**
     * 用户ID
     * USER_ID
     */
    private String userId;

    /**
     * 上次登录成功时间
     * LAST_LOGIN_DATE
     */
    private Date lastLoginDate;

    /**
     * 上次登录IP
     * LAST_LOGIN_IP
     */
    private String lastLoginIp;

    /**
     * 登录失败次数
     * LOGIN_FAIL_TIMES
     */
    private Short loginFailTimes;

    /**
     * 上次登录失败时间
     * LAST_FAIL_DATE
     */
    private Date lastFailDate;
}