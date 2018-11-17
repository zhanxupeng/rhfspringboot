package com.zhan.websys.manager.login.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.zhan.websys.dao.userlogin.UserLoginMapper;
import com.zhan.websys.entity.userlogin.UserLogin;
import com.zhan.websys.manager.login.UserLoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0  2018/11/17
 * @Description todo
 */
@Component
public class UserLoginManagerImpl implements UserLoginManager {
    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public UserLogin getByUserId(String userId) {
        UserLogin userLogin = new UserLogin();
        userLogin.setUserId(userId);
        List<UserLogin> list = userLoginMapper.find(userLogin);
        return CollectionUtil.isEmpty(list) ? null : list.get(0);
    }
}
