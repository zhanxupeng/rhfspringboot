package com.zhan.websys.manager.user.impl;

import com.zhan.websys.dao.user.UserMapper;
import com.zhan.websys.entity.user.User;
import com.zhan.websys.manager.base.impl.BaseManagerImpl;
import com.zhan.websys.manager.user.UserManager;
import org.springframework.stereotype.Component;

/**
 * @author zhanxp
 * @version 1.0  2018/11/17
 * @Description todo
 */
@Component
public class UserManagerImpl extends BaseManagerImpl<UserMapper, User> implements UserManager {
}
