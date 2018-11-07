package com.zhan.websys.entity.userlogin;

import java.util.Date;

/**
 * 用户登录表
 * TSYS_USER_LOGIN
 */
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

    public String getUrid() {
        return urid;
    }

    public void setUrid(String urid) {
        this.urid = urid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Short getLoginFailTimes() {
        return loginFailTimes;
    }

    public void setLoginFailTimes(Short loginFailTimes) {
        this.loginFailTimes = loginFailTimes;
    }

    public Date getLastFailDate() {
        return lastFailDate;
    }

    public void setLastFailDate(Date lastFailDate) {
        this.lastFailDate = lastFailDate;
    }
}