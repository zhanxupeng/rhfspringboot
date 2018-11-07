package com.zhan.websys.entity.role;

import java.util.Date;

/**
 * 角色表
 * TSYS_ROLE
 */
public class Role {
    /**
     * 角色ID
     * URID
     */
    private String urid;

    /**
     * 角色代码
     * CODE
     */
    private String code;

    /**
     * 角色名称
     * NAME
     */
    private String name;

    /**
     * 排序
     * ORDER_NO
     */
    private Integer orderNo;

    /**
     * 角色类型：1-全局管理员2-租户管理员3-普通用户
     * TYPE
     */
    private String type;

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

    public String getUrid() {
        return urid;
    }

    public void setUrid(String urid) {
        this.urid = urid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}