package com.zhan.websys.manager.login;

import com.zhan.websys.entity.userlogin.UserLogin;

/**
 * @author zhanxp
 * @version 1.0  2018/11/17
 * @Description todo
 */
public interface UserLoginManager {
    UserLogin getByUserId(String userId);
}
