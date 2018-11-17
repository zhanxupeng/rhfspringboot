package com.zhan.websys.service.userlogin;

import com.zhan.websys.bo.userlogin.LoginBO;

/**
 * @author zhanxp
 * @version 1.0  2018/11/17
 * @Description todo
 */
public interface UserLoginService {
    /**
     * 是否需要验证码
     *
     * @param loginId
     * @return
     */
    boolean ifNeetCaptcha(String loginId);

    /**
     * 用户登录
     *
     * @param loginId
     * @param password
     * @return
     */
    LoginBO login(String loginId, String password, String loginIp);
}
