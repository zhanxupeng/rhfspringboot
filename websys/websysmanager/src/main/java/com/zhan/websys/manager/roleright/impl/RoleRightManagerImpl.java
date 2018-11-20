package com.zhan.websys.manager.roleright.impl;

import com.zhan.websys.dao.roleright.RoleRightMapper;
import com.zhan.websys.entity.roleright.RoleRight;
import com.zhan.websys.manager.base.impl.BaseManagerImpl;
import com.zhan.websys.manager.roleright.RoleRightManager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhanxp
 * @version 1.0 2018/11/19
 */
@Component
public class RoleRightManagerImpl extends BaseManagerImpl<RoleRightMapper, RoleRight> implements RoleRightManager {

    @Override
    public Set<String> getRightIdByRole(List<String> roleIdList) {
        return mapper.getByRole(roleIdList).stream().map(RoleRight::getOperationId).collect(Collectors.toSet());
    }
}
