package com.zhan.websys.entity.user;

import java.util.Date;

/**
 * 用户表
 * TSYS_USER
 */
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

    public String getUrid() {
        return urid;
    }

    public void setUrid(String urid) {
        this.urid = urid;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Date getPwdModifyDate() {
        return pwdModifyDate;
    }

    public void setPwdModifyDate(Date pwdModifyDate) {
        this.pwdModifyDate = pwdModifyDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(String lockStatus) {
        this.lockStatus = lockStatus;
    }
}