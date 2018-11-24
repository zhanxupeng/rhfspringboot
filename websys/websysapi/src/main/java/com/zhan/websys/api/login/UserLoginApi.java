package com.zhan.websys.api.login;

import com.zhan.websys.api.base.ResultContext;
import com.zhan.websys.api.login.vo.LoginVO;

/**
 * @author zhanxp
 * @version 1.0 2018/11/8
 */
public interface UserLoginApi {
    ResultContext<Boolean> ifNeetCaptcha(String loginId);

    ResultContext<LoginVO> login(String loginId, String password);
}
