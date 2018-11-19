package com.zhan.websys.manager.roleuser.impl;

import com.zhan.websys.dao.roleuser.RoleUserMapper;
import com.zhan.websys.entity.roleuser.RoleUser;
import com.zhan.websys.manager.base.impl.BaseManagerImpl;
import com.zhan.websys.manager.roleuser.RoleUserManager;
import org.springframework.stereotype.Component;

/**
 * @author zhanxp
 * @version 1.0 2018/11/19
 */
@Component
public class RoleUserManagerImpl extends BaseManagerImpl<RoleUserMapper, RoleUser> implements RoleUserManager {
}
