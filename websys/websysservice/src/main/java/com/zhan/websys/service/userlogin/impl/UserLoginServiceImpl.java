package com.zhan.websys.service.userlogin.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.zhan.websys.entity.user.User;
import com.zhan.websys.entity.userlogin.UserLogin;
import com.zhan.websys.manager.login.UserLoginManager;
import com.zhan.websys.manager.user.UserManager;
import com.zhan.websys.service.userlogin.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhanxp
 * @version 1.0  2018/11/17
 * @Description todo
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserManager userManager;
    @Autowired
    private UserLoginManager userLoginManager;

    @Override
    public boolean ifNeetCaptcha(String loginId) {
        boolean needCaptcha = Boolean.TRUE;
        User user = new User();
        user.setLoginId(loginId);
        List<User> userList = userManager.find(user);
        if (CollectionUtil.isNotEmpty(userList)) {
            UserLogin userLogin = userLoginManager.getByUserId(userList.get(0).getUrid());
            //第一次登录或者上一次登录成功的不需要验证码
            if (userLogin == null || userLogin.getLoginFailTimes() < 1) {
                needCaptcha = Boolean.FALSE;
            }
        }
        return needCaptcha;
    }
}
