package com.zhan.websys.manager.login.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import com.zhan.websys.common.exception.BusinessException;
import com.zhan.websys.common.exception.SystemException;
import com.zhan.websys.dao.userlogin.UserLoginMapper;
import com.zhan.websys.entity.userlogin.UserLogin;
import com.zhan.websys.manager.login.UserLoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
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

    @Override
    public void add(UserLogin userLogin) {
        userLogin.setLoginFailTimes(0);
        userLogin.setUrid(IdUtil.simpleUUID());
        int insert = userLoginMapper.insert(userLogin);
        if (insert != 1) {
            throw new SystemException("插入用户登录记录失败");
        }
    }

    @Override
    public void edit(UserLogin userLogin) {
        int update = userLoginMapper.update(userLogin);
        if (update != 1) {
            throw new SystemException("更新用户登录记录失败");
        }
    }
}
