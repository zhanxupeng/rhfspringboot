package com.zhan.websys.manager.role.impl;

import com.zhan.websys.dao.role.RoleMapper;
import com.zhan.websys.entity.role.Role;
import com.zhan.websys.manager.base.impl.BaseManagerImpl;
import com.zhan.websys.manager.role.RoleManager;
import org.springframework.stereotype.Component;

/**
 * @author zhanxp
 * @version 1.0 2018/11/19
 */
@Component
public class RoleManagerImpl extends BaseManagerImpl<RoleMapper, Role> implements RoleManager {

}
