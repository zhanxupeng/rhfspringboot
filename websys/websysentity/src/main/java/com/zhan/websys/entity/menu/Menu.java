package com.zhan.websys.entity.menu;

import java.util.Date;

/**
 * 系统菜单表
 * TSYS_MENU
 */
public class Menu {
    /**
     * 菜单ID
     * URID
     */
    private String urid;

    /**
     * 菜单编码
     * CODE
     */
    private String code;

    /**
     * 菜单名称
     * NAME
     */
    private String name;

    /**
     * 菜单图标
     * ICON
     */
    private String icon;

    /**
     * 菜单请求地址
     * URL
     */
    private String url;

    /**
     * 是否启用：0-否，1-是
     * ACTIVE_FLAG
     */
    private String activeFlag;

    /**
     * 上级菜单ID
     * PARENT_ID
     */
    private String parentId;

    /**
     * 菜单索引路径
     * INDEX_PATH
     */
    private String indexPath;

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
     * 是否在菜单树展示：0-否，1-是
     * SHOW_FLAG
     */
    private String showFlag;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getIndexPath() {
        return indexPath;
    }

    public void setIndexPath(String indexPath) {
        this.indexPath = indexPath;
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

    public String getShowFlag() {
        return showFlag;
    }

    public void setShowFlag(String showFlag) {
        this.showFlag = showFlag;
    }
}