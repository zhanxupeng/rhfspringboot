package com.zhan.websys.service.userlogin;

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
}
