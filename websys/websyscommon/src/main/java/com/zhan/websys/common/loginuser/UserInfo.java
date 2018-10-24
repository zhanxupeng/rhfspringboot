package com.zhan.websys.common.loginuser;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Setter
@Getter
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -5165209452487667711L;
    private String userId;
    private String loginId;
    private String userName;
    private String tenantIds;

    public List<String> getTenantIdList() {
        return StrUtil.isBlank(tenantIds) ? new LinkedList<>()
                : Arrays.asList(tenantIds.split(StrUtil.COMMA));
    }
}
