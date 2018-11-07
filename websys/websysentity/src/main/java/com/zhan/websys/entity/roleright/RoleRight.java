package com.zhan.websys.entity.roleright;

import java.util.Date;

/**
 * 角色权限表
 * TSYS_ROLE_RIGHT
 */
public class RoleRight {
    /**
     * 角色权限ID
     * URID
     */
    private String urid;

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

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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