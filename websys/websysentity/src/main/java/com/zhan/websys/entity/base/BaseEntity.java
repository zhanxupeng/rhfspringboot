package com.zhan.websys.entity.base;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.zhan.websys.common.loginuser.UserContext;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
@Getter
@Setter
public class BaseEntity {
    /**
     * 菜单ID
     * URID
     */
    private String urid;
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

    private void init() {
        this.urid = IdUtil.simpleUUID();
        this.creator = UserContext.getUserId();
        this.createDate = new Date();
        this.updator = UserContext.getUserId();
        this.updateDate = new Date();
        this.version = 1L;
    }

    private void edit() {
        this.updator = UserContext.getUserId();
        this.updateDate = new Date();
        if (ObjectUtil.isNull(version)) {
            throw new RuntimeException("修改数据时，版本号不能为空");
        }
        this.version = this.version + 1;
    }

}
