package com.zhan.websys.manager.roleright;

import com.zhan.websys.entity.roleright.RoleRight;
import com.zhan.websys.manager.base.BaseManager;

import java.util.List;
import java.util.Set;

/**
 * @author zhanxp
 * @version 1.0 2018/11/19
 */
public interface RoleRightManager extends BaseManager<RoleRight> {
    Set<String> getRightIdByRole(List<String> roleIdList);
}
